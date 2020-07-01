package scenarios.scn_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StringManupulation {
	
	WebDriver driver;
	int i = 0;

	@Given("I have browser opened and url is navigated to {string} and validate title")
	public void i_have_browser_opened_and_url_is_navigated_to_and_validate_title(String url) {
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

	@When("I Enter product Name {string} in SearchBox and validate search box is visible")
	public void i_Enter_product_Name_in_SearchBox_and_validate_search_box_is_visible(String text) {
		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		Assert.assertEquals(true, search.isDisplayed());
		search.sendKeys(text);
		driver.findElement(By.xpath("//button[@class='vh79eN']//*[local-name()='svg']")).click();
	}

	@Then("I fetch all prices from the first page and make total with all the prices and print it on console")
	public void i_fetch_all_prices_from_the_first_page_and_make_total_with_all_the_prices_and_print_it_on_console() {
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
		int tsize = prices.size();
		int con = Integer.parseInt(
				driver.findElement(By.xpath("//div[@class='_1vC4OE']")).getText().replaceAll("[^0-9]", ""));
		int p = 0;
		for (int i = 0; i <= tsize; i++) {
			p += con;
		}
		System.out.println(p);
	}


}
