package scenarios.scn_2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSugestList {

	@Test
	
	public void AutosuggetPrint() throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/mobile-apps");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		

	WebElement searchBox=driver.findElement(By.xpath("//input[@class='LM6RPg']"));
	searchBox.clear();
	
	System.out.println("dispaly search Box:"+searchBox.isDisplayed());

	searchBox.sendKeys("philips");
	
	Thread.sleep(1000);

	List<WebElement> listOfSugetion=driver.findElements(By.xpath("//div[@class='_2kpuIQ _1rB4Ez']"));


	System.out.println("size of autosuggetion: " + listOfSugetion.size());

	for(int i = 1; i < listOfSugetion.size(); i++) 
	{
		String listOfText = driver.findElements(By.xpath("//li[@class='_1va75j']/div/a/div[@class='_2kpuIQ _1rB4Ez']")).get(i).getText();
		
		System.out.println("AutoSugetionList:" +listOfText);
		


	}
	}
}
