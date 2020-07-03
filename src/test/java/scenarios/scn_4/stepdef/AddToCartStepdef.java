package scenarios.scn_4.stepdef;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import scenarios.scn_4.context.TextContext;

public class AddToCartStepdef {

	TextContext textContext;
	Scenario scn;
	String firstProduct;
	String secondProduct;
	String thirdProduct;
	
	public AddToCartStepdef(TextContext textContext) {
		this.textContext = textContext;
	}
	
	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.in/");
		 	 
		//Assign driver and set page Objects to TextContext 
		 textContext.setDriver(driver);
		 textContext.InitializePageObjectClasses(driver, scn);
		 textContext.getAddToCartPageObject().ValidatePageTitle();
	}
	
	@Given("I have {int} products added in the cart")
	public void i_have_products_added_in_the_cart(Integer proCount) throws Exception {
		//Adding first product
		textContext.getAddToCartPageObject().SetSearchTextBox("Laptop");
		textContext.getAddToCartPageObject().ClickOnSearchButton();
		firstProduct=textContext.getAddToCartPageObject().ClickOnProductLink();
		i_click_on_Add_To_Cart_button();
		textContext.getDriver().close();
		textContext.getDriver().switchTo().window((String)textContext.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
		textContext.getAddToCartPageObject().ClearSearchTextBox();	
		
		//Adding second product
		textContext.getAddToCartPageObject().SetSearchTextBox("Earphone");
		textContext.getAddToCartPageObject().ClickOnSearchButton();
		secondProduct=textContext.getAddToCartPageObject().ClickOnProductLink();
		i_click_on_Add_To_Cart_button();
		textContext.getDriver().close();
		textContext.getDriver().switchTo().window((String)textContext.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
		textContext.getAddToCartPageObject().ClearSearchTextBox();	
		
		//Adding third product
		textContext.getAddToCartPageObject().SetSearchTextBox("samsung galaxy");
		textContext.getAddToCartPageObject().ClickOnSearchButton();
		thirdProduct=textContext.getAddToCartPageObject().ClickOnProductLink();
		i_click_on_Add_To_Cart_button();
		textContext.getDriver().close();
		textContext.getDriver().switchTo().window((String)textContext.getDriver().getWindowHandles().toArray()[0]).navigate().refresh();
		textContext.getAddToCartPageObject().ClearSearchTextBox();	
	}

	@And("I click on Add To Cart button")
	public void i_click_on_Add_To_Cart_button() throws Exception {
		textContext.getDriver().switchTo().window((String)textContext.getDriver().getWindowHandles().toArray()[1]);
		textContext.getAddToCartPageObject().ClickOnAddToCartBtn();
		Thread.sleep(10000);
	}

	@Then("I validate the sequence of product is same as like they added in the cart")
	public void i_validate_the_sequence_of_product_is_same_as_like_they_added_in_the_cart() {
		textContext.getAddToCartPageObject().ClickOnCartBtn();
		textContext.getAddToCartPageObject().ValidateFirstProduct(thirdProduct);
		textContext.getAddToCartPageObject().ValidateSecondProduct(secondProduct);
		textContext.getAddToCartPageObject().ValidateThirdProduct(firstProduct);		
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
