package scenarios.scn_1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
    WebDriver driver;
    String url="https://www.flipkart.com/";
    String title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
    int add=0;
    @Test
    public void MethodAssignment1() throws InterruptedException {
    WebDriver driver=new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    Assert.assertEquals(title,driver.getTitle());
    System.out.println("Page title is: "+driver.getTitle());
    driver.manage().window().maximize();
    
    driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	
    Thread.sleep(4000);
	
    WebElement SearchBox =driver.findElement(By.xpath("//input[@class='LM6RPg']"));
    System.out.println("SearchBox is displays: "+SearchBox.isDisplayed());
    SearchBox.sendKeys("OnePlus");
    driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    List<WebElement>Prices=driver.findElements(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[@class='_1vC4OE']"));
    int n=Prices.size();	
    System.out.println("TotalProduct: "+n);
    
    int i=0;
    while(i<Prices.size())
    {
    	String Name=Prices.get(i).getText().replace("₹","").replace(",","");
    	System.out.println("ProductCost: "+Name);
    	int convert=Integer.parseInt(Name);
        add=add+convert;	
        System.out.println("TotalCost: "+add);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
        i++;
    }
  }
}
                                          


