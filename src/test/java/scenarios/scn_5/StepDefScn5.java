package scenarios.scn_5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class StepDefScn5 extends TestBase_1{

	TestDI di;
	public StepDefScn5(TestDI di){
		this.di=di;
	}
	WebDriver driver ;
	Scenario scn;
	String product_1;
	String product_2;
	String product_3;
	
	@Given("I have browser open and url is navigated and validate the title")
	public void i_have_browser_open_and_url_is_navigated_and_validate_the_title() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.get(amazon_url);
		di.setDriver(driver);
		di.GetInstanceOfPageObject(driver, scn);
		String actual_title=driver.getTitle();
		//System.out.println(actual_title);
		di.getPm().ValidateAmazonTitle(actual_title);
	}

	@Then("I click on all link available on footer Section and Fetch it")
	public void i_click_on_all_link_available_on_footer_Section_and_Fetch_it() {
		di.getPm().ClickLinkAndFetchTitle();
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


