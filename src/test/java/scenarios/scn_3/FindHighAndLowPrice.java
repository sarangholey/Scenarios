package scenarios.scn_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindHighAndLowPrice {
	WebDriver driver;
	int i;
	int tmp;
	int max;
	int min;

	@Given("I have browser opened and url is navigated to {string} and validate titleee")
	public void i_have_browser_opened_and_url_is_navigated_to_and_validate_titleee(String url) {
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

	@When("I Enter product Name {string} in SearchBox and validate search box is visiblee")
	public void i_Enter_product_Name_in_SearchBox_and_validate_search_box_is_visiblee(String text) {
		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		Assert.assertEquals(true, search.isDisplayed());
		search.sendKeys(text);
		driver.findElement(By.xpath("//button[@class='vh79eN']//*[local-name()='svg']")).click();
	}

	@And("I Select Min Price {string} and max price {string} from price filter dropdown in left side, also validate min and max price dropdown is visible .")
	public void i_Select_Min_Price_and_max_price_from_price_filter_dropdown_in_left_side_also_validate_min_and_max_price_dropdown_is_visible(
			String minValue, String maxValue) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement mindropdown = driver.findElement(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']"));
		Assert.assertEquals(true, mindropdown.isDisplayed());
		Select minpricedropdown = new Select(mindropdown);
		minpricedropdown.selectByValue("10000");
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement maxprice = driver.findElement(By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']"));
			Assert.assertEquals(true, maxprice.isDisplayed());
			Select maxpricedropdown = new Select(maxprice);
			maxpricedropdown.selectByValue("30000");
		} catch (StaleElementReferenceException e) {
			WebElement maxprice = driver.findElement(By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']"));
			Assert.assertEquals(true, maxprice.isDisplayed());
			Select maxpricedropdown = new Select(maxprice);
			maxpricedropdown.selectByValue("30000");
		}
	}

	@Then("I fetch and print one lowest and one highest price commdity from the list on console with their respective names.")
	public void i_fetch_and_print_one_lowest_and_one_highest_price_commdity_from_the_list_on_console_with_their_respective_names() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		List<WebElement> priceofAllMobiles = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		priceofAllMobiles.size();
		ArrayList<Integer> Array = new ArrayList<Integer>();
		
		for (int i = 0; i <= priceofAllMobiles.size(); i++) {
			String mobileCost = priceofAllMobiles.get(i).getText();
			String remove=mobileCost.replace("₹","").replace(",","");
			int actualPrice=Integer.parseInt(remove);
			
			
			//String mobileCost = priceofAllMobiles.get(i).getText().replaceAll("[^0-9]", "");
		//	int actualPrice = Integer.parseInt(mobileCost);
			System.out.println(actualPrice);
			Array.add(actualPrice);
			Integer max = Collections.max(Array);
			System.out.println(max);
		//	Integer min = Collections.min(Array);
		//	System.out.println(min);

		}
/*
		for (int i = 0; i <= priceofAllMobiles.size(); i++) {
			String mobileCost = priceofAllMobiles.get(i).getText().replaceAll("[^0-9]", "");
			int actualPrice = Integer.parseInt(mobileCost);
			System.out.println(actualPrice);
			Array.add(actualPrice);
			Integer min = Collections.min(Array);
			System.out.println(min);
		}
*/
		System.out.println("max" + Collections.max(Array, null));
		System.out.println("min" + Collections.min(Array, null));
	}

}
