package scenarios.scn_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.staticmethod.WebDriverManagerSimple;


public class ScenarioStepDefs_1 extends TestBase
{
	TestContext testContext;
	Scenario scn;
	String TextTitleValue;
	public ScenarioStepDefs_1(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	@Given("I have browser opened and url is navigated and validate the title")
	public void i_have_browser_opened_and_url_is_navigated_and_validate_the_title() 
	{
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(server);
		testContext.setDriver(driver);
		testContext.initializePageObjectClasses(driver, scn);
		testContext.getScenarioObjects_1().CancelButton();
		testContext.getScenarioObjects_1().validateFilpkartTitle();	
	}

	@When("Enter product as {string} in serachbox also validate the searchbox is visible")
	public void enter_product_as_in_serachbox_also_validate_the_searchbox_is_visible(String productName) {
		testContext.getScenarioObjects_1().validateSearchBoxTitle();
	    testContext.getScenarioObjects_1().SetSearchTextBox(productName);
	    testContext.getScenarioObjects_1().ClickOnSearchButton();
	   // testContext.getScenarioObjects_1().fetchAllProductPrice();
	    
	}

	@Then("Fatch all the product prices from the first page Make total of it and print on console")
	public void fatch_all_the_product_prices_from_the_first_page_make_total_of_it_and_print_on_console() {
	    testContext.getScenarioObjects_1().fetchAllProductPrice();
	}

	

}
