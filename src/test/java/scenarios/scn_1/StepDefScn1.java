package scenarios.scn_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefScn1 extends TestBase_1 {

	TestDI di;
	public StepDefScn1(TestDI di){
		this.di=di;
	}
	WebDriver driver ;
	Scenario scn;
	
	@Given("I have browser open and url is navigated and validate the title")
	public void i_have_browser_open_and_url_is_navigated_and_validate_the_title() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(serverUI);
		di.setDriver(driver);
		di.GetInstanceOfPageObject(driver, scn);
		di.getPm().ClickOnLoginPopUp();
		String actual_title=driver.getTitle();
		di.getPm().ValidateTitle(actual_title);
	}

	@When("I Search for product as {string} and also validate the searchbox is visible or not")
	public void i_Search_for_product_as_and_validate_the_searchbox_is_visible(String product_name) {
		di.getPm().SearchProduct(product_name);
		di.getPm().ValidateSearchBox();
	}

	@Then("I Fetch all the prices from the first page and make total of all prices and print it on console window")
	public void make_total_of_all_prices_and_print_it_on_console_window() {
	di.getPm().TotalCostOfAllProduct();
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
