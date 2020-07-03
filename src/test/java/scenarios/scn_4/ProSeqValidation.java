package scenarios.scn_4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProSeqValidation {
	WebDriver driver;
	@Given("I have browser opened and url is navigated to {string} and validate titleeeee")
	public void i_have_browser_opened_and_url_is_navigated_to_and_validate_titleeeee(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@When("I Add any three products in cart")
	public void i_Add_any_three_products_in_cart() throws Exception {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("shirts");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		List<WebElement> Products=driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		
	   for (int i = 0; i < 3; i++) {
		   Products=driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		   System.out.println("Added Product Name :"+Products.get(i).getText());
		   Products.get(i).click();
		   Set<String> item=driver.getWindowHandles();
		   Iterator<String> window=item.iterator();
		   String parentWindow =window.next();
		   String ChildWindow = window.next();
		   driver.switchTo().window(ChildWindow);
		   driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).isDisplayed();
		   new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button']"))).click();
		   driver.close();
		   driver.switchTo().window(parentWindow);
		   driver.navigate().refresh();
			
		}
	   
	}

	@Then("I validate whether sequnce of product is same as like they added in cart.")
	public void i_validate_whether_sequnce_of_product_is_same_as_like_they_added_in_cart() {
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		List<WebElement> addedProductsInCart= driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
		for(int a=0;a<3;a++) {
			addedProductsInCart= driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
			String nameofCartProducts= addedProductsInCart.get(a).getText();
			System.out.println("CardProduct: "+nameofCartProducts);
			
		}
	}

}
