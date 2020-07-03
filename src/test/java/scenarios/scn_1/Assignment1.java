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
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Page title is: "+driver.getTitle());
    Assert.assertEquals(title,driver.getTitle());
     
	driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	
   
    WebElement SearchBox =driver.findElement(By.xpath("//input[@class='LM6RPg']"));    
    boolean v=SearchBox.isDisplayed();
	if (v) {
	Assert.assertTrue("SearchBox is visible",true);}
	else {
	Assert.fail("SearchBox is not visible");}
	
    SearchBox.sendKeys("OnePlus");
    driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
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
        i++;
    }
    System.out.println("TotalCost: "+add);
  }
}
                                          


