package scenarios.scn_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentOneScenarioOne {

	@Test
	public void FlipkartAssignment() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dishu\\Work-Selenium\\Drivers\\chromedriver_win32_v83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);	//validated if page Title is displayed
		System.out.println("Successfully validated Page Title");

		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	//click on close button of the frame

		//validating if searchbox is displayed
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		Boolean b = searchBox.isDisplayed();
		if(b) {
			System.out.println("SearchBox is displayed");
		}else {
			System.out.println("SearchBox is not displayed");
		}
		searchBox.sendKeys("OnePlus");
		driver.findElement(By.xpath("//button[@class='vh79eN']")).click();	//click on search button
		List<WebElement> priceOfProducts = driver.findElements(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[@class='_1vC4OE']"));
		int size = priceOfProducts.size();
		System.out.println(size);
		int count = 0;
		int c = 1;
		for(int i = 1; i < size; i++) {
			String price = priceOfProducts.get(i).getText().replace("₹","").replace(",","");
			int p = Integer.parseInt(price);
			System.out.println("Price of " +  i + " product is :" + p);
			count = count + p;
		}
		System.out.println("\nSum of All the Prices is: " + count);
		driver.quit();
	}

}
