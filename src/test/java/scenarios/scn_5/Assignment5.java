package scenarios.scn_5;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
	WebDriver driver;
	String url="https://www.amazon.in/";
	String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	@Test
	public void MethodAssignment5() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Page title is: "+driver.getTitle());
    Assert.assertEquals(title,driver.getTitle());
    
    WebElement footer=driver.findElement(By.xpath("//div[@id='navFooter']"));
    int size=footer.findElements(By.tagName("a")).size();
    System.out.println("links in footer"+size);
    List<WebElement> footerlinks = footer.findElements(By.tagName("a"));
    for(int i=0;i<size;i++)
    {
        footer=driver.findElement(By.xpath("//div[@id='navFooter']"));
        footer.findElements(By.tagName("a")).get(i).click();
    	Thread.sleep(5000);
    	System.out.println(driver.getTitle());
    	driver.navigate().back();
    	Thread.sleep(4000);
    }
    
}
}
