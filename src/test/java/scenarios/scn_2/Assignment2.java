package scenarios.scn_2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	WebDriver driver;
	String url="https://www.flipkart.com/";
	String title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	String Product="philips";
	
	@Test
	public void MethodAssignment2() throws InterruptedException {
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
    SearchBox.sendKeys("Philips");
    
    Thread.sleep(3000);
    List<WebElement> Autosuggestion = driver.findElements(By.xpath("//a[@class='_2ja22P']"));	
    System.out.println("Total number of Autosuggestion Product: "+Autosuggestion.size());
    
    for(int i=0;i<Autosuggestion.size();i++)
    {
    Autosuggestion=driver.findElements(By.xpath("//a[@class='_2ja22P']"));
    String Product=Autosuggestion.get(i).getText();
	System.out.println(Product);	
	Assert.assertTrue("Autosuggection is contain philips: ",Product.contains("philips"));
    }
  }
}