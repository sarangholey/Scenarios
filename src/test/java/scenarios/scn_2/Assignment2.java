package scenarios.scn_2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    Assert.assertEquals(title,driver.getTitle());
    System.out.println("Page title is: "+driver.getTitle());
    driver.manage().window().maximize();
    
    driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	
	
    WebElement SearchBox =driver.findElement(By.xpath("//input[@class='LM6RPg']"));
    System.out.println("SearchBox is displays: "+SearchBox.isDisplayed());
    SearchBox.sendKeys("Philips");
    Thread.sleep(5000);
    
    List<WebElement> Autosuggestion = driver.findElements(By.xpath("//a[@class='_2ja22P']"));	
    System.out.println("Total number of Autosuggestion Product: "+Autosuggestion.size());
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
    int i=0;
    while(i<Autosuggestion.size())
    {
	String product=Autosuggestion.get(i).getText();
	boolean display= Autosuggestion.get(i).isDisplayed();
	System.out.println(display);
	if(product.startsWith("philips")) {
    System.out.println("Product start with small letter: "+product);
	}
	if(product.startsWith("Philips")){
		System.out.println("Product Start with Capital Letter: "+product);
	}
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
	i++;
    }
  }
}
