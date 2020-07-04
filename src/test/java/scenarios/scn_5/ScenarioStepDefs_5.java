package scenarios.scn_5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import context.TestBase;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.manager.driver.staticmethod.WebDriverManagerSimple;

public class ScenarioStepDefs_5 extends TestBase
{
	TestContext testContext;
	Scenario scn;
	public ScenarioStepDefs_5(TestContext testContext)
	{
		this.testContext=testContext;
	}
	@Given("I have browser open and url is navigated and validate the title")
	public void i_have_browser_open_and_url_is_navigated_and_validate_the_title() {
		WebDriver driver = WebDriverManagerSimple.getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(server1);
		testContext.setDriver(driver);
		testContext.initializePageObjectClasses(driver, scn);
		testContext.getScenarioObjects_4().validateAmazonTitle();
	}

	@Then("I click on all link available on footer Section and Fetch it")
	public void i_click_on_all_link_available_on_footer_Section_and_Fetch_it() {
	    testContext.getScenarioObject_5().GetAllLinkAndPrint();
	}
	
	


}
