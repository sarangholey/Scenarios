package scenarios.scn_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.staticmethod.WebDriverManagerSimple;

public class ScenarioStepDefs_3 extends TestBase 
{
	TestContext testContext;
	Scenario scn;
	
	public ScenarioStepDefs_3 (TestContext testContext)
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

	@When("I Enter product as {string} in serachbox also validate the searchbox is visible")
	public void i_enter_product_as_in_serachbox_also_validate_the_searchbox_is_visible(String productName) {
		testContext.getScenarioObjects_1().validateSearchBoxTitle();
	    testContext.getScenarioObjects_1().SetSearchTextBox(productName);
	    testContext.getScenarioObjects_1().ClickOnSearchButton();
	}
	@When("I Select maximum and minimum value of the product and validate the dropdown of max and min value")
	public void i_Select_maximum_and_minimum_value_of_the_product_and_validate_the_dropdown_of_max_and_min_value() {
	    testContext.getScenarioObject_3().fetchMinimumValue();
	    testContext.getScenarioObject_3().fetchMaximumValue();
	    
	}

	@Then("I fetch price and name of the product from commodity & print on console")
	public void i_fetch_price_and_name_of_the_product_from_commodity_print_on_console() {
	    testContext.getScenarioObject_3().lowestPriceProduct();
	    testContext.getScenarioObject_3().highPriceProduct();
	}


}
