package scenarios.scn_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Assignment5 {
@Test

	public void StaleElement()
	{
WebDriver driver=new ChromeDriver();
	
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	
String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in ";
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle);	
System.out.println("Successfully validated Page Title");

	
	WebElement footerLink=driver.findElement(By.xpath("//td[@class='navFooterDescItem']"));
System.out.println(footerLink.getText());
	
List<WebElement> ALL_LINK=driver.findElements(By.xpath("//td[@class='navFooterDescItem']//a"));
for(int i=0;i<ALL_LINK.size();i++)
{
	ALL_LINK.get(i).click();
	
	footerLink=driver.findElement(By.xpath("//td[@class='navFooterDescItem']"));
	System.out.println((i+1) +"  -"+footerLink.getText());
	driver.navigate().back();
	
	ALL_LINK= driver.findElements(By.xpath("//td[@class='navFooterDescItem']//a"));
	
	
}

	
	}
}
