package scenarios.scn_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import scenarios.scn_1.TestDI;

public class StepDefScn2 {

	TestDI di;
	public StepDefScn2(TestDI di){
		this.di=di;
	}
	WebDriver driver ;
	Scenario scn;
	String url="https://www.flipkart.com/";

	@Given("I have browser open and url is navigated and validate the title")
	public void i_have_browser_open_and_url_is_navigated_and_validate_the_title() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		di.setDriver(driver);
		di.GetInstanceOfPageObject(driver, scn);
		di.getPm().ClickOnLoginPopUp();
		String actual_title=driver.getTitle();
		di.getPm().ValidateTitle(actual_title);
	}

	@When("Enter the product name {string} in SearchBox and also validate the searchbox is visible or not")
	public void enter_the_product_name_in_SearchBox_and_also_validate_the_searchbox_is_visible_or_not(String productName) {
		di.getPm().SetProductInSearchBox(productName);
		di.getPm().ValidateSearchBox();
	}

	@Then("Print and validate the keyword {string} coming in the quick suggestion drop down.")
	public void print_and_validate_the_keyword_coming_in_the_quick_suggestion_drop_down(String productName) throws InterruptedException {
		di.getPm().ValidateDropDownSuggestion(productName);
	}	
	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@After
	public void CleanUp(Scenario s) {

		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)di.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}

		di.getDriver().quit();
		scn.write("Browser is Closed");
	}

}
