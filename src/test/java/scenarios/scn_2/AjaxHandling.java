package scenarios.scn_2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AjaxHandling {

	WebDriver driver;

	@Given("I have browser opened and url is navigated to {string} and validate titlee")
	public void i_have_browser_opened_and_url_is_navigated_to_and_validate_titlee(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
		element.click();
		String expected = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@When("I Enter product Name {string} in SearchBox and validate search box is visible or not")
	public void i_Enter_product_Name_in_SearchBox_and_validate_search_box_is_visible_or_not(String text) {
		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		Assert.assertEquals(true, search.isDisplayed());
		search.sendKeys(text);
		search.click();
		Assert.assertEquals(true, search.isDisplayed());

	}

	@Then("I print and validate the keyword Philips is coming in the quick suggestion drop down.")
	public void i_print_and_validate_the_keyword_Philips_is_coming_in_the_quick_suggestion_drop_down() {

		List<WebElement> list = driver.findElements(By.xpath("//a[@class='_2ja22P']"));
		System.out.println("Elements in Drop Down List: " + list.size());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (int i = 0; i < list.size(); i++) {
			String product = list.get(i).getText();
			boolean display = list.get(i).isDisplayed();
			System.out.println(display);
			if (product.startsWith("philips")) {
				System.out.println("Suggetion List: " + product);
			}
			if (product.startsWith("Philips")) {
				System.out.println("Suggetion List " + product);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}

}