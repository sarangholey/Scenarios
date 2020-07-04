package scenarios.scn_4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.staticmethod.WebDriverManagerSimple;

public class ScenarioStepDefs_4 extends TestBase
{
	TestContext testContext;
	Scenario scn;
	public ScenarioStepDefs_4(TestContext testContext)
	{
		this.testContext=testContext;
	}

	@Given("I have browser opened and url is navigated and validate the title")
	public void i_have_browser_opened_and_url_is_navigated_and_validate_the_title() {
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(server1);
		testContext.setDriver(driver);
		testContext.initializePageObjectClasses(driver, scn);
		testContext.getScenarioObjects_4().validateAmazonTitle();
	    
	}
	@When("I Enter product as {string} in serachbox")
	public void i_Enter_product_as_in_serachbox(String productName) {
	    testContext.getScenarioObjects_4().SetSearchTextBox(productName);
	    
	}


	@When("I add few product in the cart")
	public void i_add_few_product_in_the_cart() {
	    testContext.getScenarioObjects_4().AddProductsToCart();
	    testContext.getScenarioObjects_4().GetCartProductList();
	}

	@Then("I validate the cart for sequence of the product")
	public void i_validate_the_cart_for_sequence_of_the_product() {
		testContext.getScenarioObjects_4().validateCartItemSequence();
	   
	}


}
