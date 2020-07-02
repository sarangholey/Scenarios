package scenarios.scn_3.stepdef;

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
import scenarios.scn_3.context.TextContext;

public class SearchStepDef {

	TextContext textContext;
	Scenario scn;
	String productClickedTextExpected;
	
	public SearchStepDef(TextContext textContext) {
		this.textContext = textContext;
	}
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.flipkart.com/");
		 	 
		//Assign driver and set page Objects to TextContext 
		 textContext.setDriver(driver);
		 textContext.InitializePageObjectClasses(driver, scn);
		 textContext.getSearchPageObjects().ValidatePageTitle();
	}

	@Given("I search for the product as {string}")
	public void i_search_for_the_product_as(String product) {
		textContext.getSearchPageObjects().ClickOnCloseBtn();
		textContext.getSearchPageObjects().SetSearchTextBox(product);
		textContext.getSearchPageObjects().ClickOnSearchBox();
	}

	@When("I select minimum and maximum price range from the filters dropdown")
	public void i_select_minimum_and_maximum_price_range_from_the_filters_dropdown() throws InterruptedException {
		textContext.getSearchPageObjects().ValidateFilterDropdownBoxPresent();
		textContext.getSearchPageObjects().SelectMinAndMaxRangeForTheProduct();
	}

	@Then("I print one lowest and highest price product from the updated product list")
	public void i_print_one_lowest_and_highest_price_product_from_the_updated_product_list() {
		textContext.getSearchPageObjects().PrintlowestAndHighestPriceProductFromUpdatedList();
	}

	@Before
	public void SetUp(Scenario s) {
		this.scn = s;
	}

	@After
	public void CleanUp(Scenario s) {
		
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)textContext.getDriver();
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.embed(data, "image/png");
		}
		
		//textContext.getDriver().quit();
		//scn.write("Browser is Closed");
	}

}
