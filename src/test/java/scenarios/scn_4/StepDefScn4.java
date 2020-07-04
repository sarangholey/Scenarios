package scenarios.scn_4;

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

public class StepDefScn4 extends TestBase_1{

	TestDI di;
	public StepDefScn4(TestDI di){
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
		di.getPm().ValidateAmazonTitle(actual_title);
	}

	@When("I add few product in cart")
	public void i_add_few_product_in_cart() {
		di.getPm().SearchProductInAmazon("iphone");;		
		di.getPm().SelectAndAddProductToCart();
	}

	@Then("Validate sequence of product is same")
	public void validate_sequence_of_product_is_same() {
		di.getPm().CartMenu();
		di.getPm().ValidateCartProductList();
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
