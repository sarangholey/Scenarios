package scenarios.scn_3;

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
import scenarios.scn_1.TestBase_1;
import scenarios.scn_1.TestDI;


public class StepDefScn3 extends TestBase_1{

	TestDI di;
	public StepDefScn3(TestDI di){
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

	@When("Apply filter with min price as {string} and max price as {string}")
	public void apply_filter_with_min_price_as_and_max_price_as(String minPrice, String maxPrice) throws InterruptedException {
		
		di.getPm().ValidateMinCostDropDown();
		di.getPm().ValidateMaxCostDropDown();
		di.getPm().SelectMinCost();
		di.getPm().SelectMaxCost();		
	}

	@Then("Validate min and max price dropdown is visible or not also fetch Highest and Lowest price commodity from list with their name.")
	public void validate_min_and_max_price_dropdown_is_visible_or_not_also_fetch_Highest_and_Lowest_price_commodity_from_list_with_their_name() throws InterruptedException {
		di.getPm().GetTheHighestAndLowestPriceOfCommodity();
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
