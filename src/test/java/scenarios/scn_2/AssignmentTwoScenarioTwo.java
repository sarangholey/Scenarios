package scenarios.scn_2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AssignmentTwoScenarioTwo {

	@Test
	public void ScenarioTwo() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dishu\\Work-Selenium\\Drivers\\chromedriver_win32_v83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	//click on close button of the frame
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);	//validated if page Title is displayed
		System.out.println("Successfully validated Page Title");

		//validating if searchbox is displayed
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		Boolean b = searchBox.isDisplayed();
		if(b) {
			System.out.println("SearchBox is displayed");
		}else {
			System.out.println("SearchBox is not displayed");
		}
		String actualSearchedValue = "Philips";
		String expectedSearchedValue = "Philips";
		searchBox.sendKeys(actualSearchedValue);
		Thread.sleep(1500);
		List<WebElement> autosuggestion = driver.findElements(By.xpath("//div[@class='_2kpuIQ _1rB4Ez']"));
		System.out.println("Size of autosuggestion list is: " + autosuggestion.size());
		for(int i = 1; i < autosuggestion.size(); i++) {
			String autosuggestionText = driver.findElements(By.xpath("//li[@class='_1va75j']/div/a/div[@class='_2kpuIQ _1rB4Ez']")).get(i).getText();
			System.out.println(autosuggestionText);
			Assert.assertEquals(actualSearchedValue, expectedSearchedValue, "Searched string value did not match with the enterred keyword");
		}
		driver.quit();
	}
}

