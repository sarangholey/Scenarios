package scenarios.scn_1.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import scenarios.scn_1.context.TextContext;

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
		 
		//Assign driver and set page Objects to Test Context 
		 textContext.setDriver(driver);
		 textContext.InitializePageObjectClasses(driver, scn);
	}

	@Given("I search for the product as {string}")
	public void i_search_for_the_product_as(String product) {
		textContext.getSearchPageObjects().ClickOnCloseBtn();
		textContext.getSearchPageObjects().SetSearchTextBox(product);
		textContext.getSearchPageObjects().ClickOnSearchBox();
	}

	@When("I fetch all the prices from the first page")
	public void i_fetch_all_the_prices_from_the_first_page() {
		textContext.getSearchPageObjects().FetchAllThePricesPresentOnFirstPage();
	}

	@Then("I print sum of all the prices on the console")
	public void i_print_sum_of_all_the_prices_on_the_console() {
		textContext.getSearchPageObjects().SumAllThePricesPresentOnFirstPg(); 
	}

}
