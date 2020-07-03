package scenarios.scn_4;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    WebDriver driver;
    String url="https://www.amazon.in/";
    String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

    @Test
    public void MethodAssignment4() throws InterruptedException {
    WebDriver driver=new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Page title is: "+driver.getTitle());
    Assert.assertEquals(title,driver.getTitle());
    
    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("pot");
    driver.findElement(By.xpath("//input[@value='Go']")).click();
   
    List<WebElement> Product=driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
    Thread.sleep(5000);
    System.out.println("Number of Product"+Product.size());
    for(int i=0;i<3; i++)
    {
    Product=driver.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
    Product.get(i).click();
    Thread.sleep(3000);
    Set<String> ids=driver.getWindowHandles();	
	Iterator<String> it=ids.iterator();
    String parentwin=it.next();
    String childwin= it.next();
	driver.switchTo().window(childwin);
	
    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).isDisplayed();
    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    Thread.sleep(3000);
    driver.close();
    driver.switchTo().window(parentwin);
    driver.navigate().refresh();
	}
    Thread.sleep(3000);
    driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
    List<WebElement> Count= driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
    for(int j=0;j<3;j++) {
    Count= driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
    String CardProduct= Count.get(j).getText();
    System.out.println("CardProduct: "+CardProduct);
    }
    Thread.sleep(3000);
    String details=driver.findElement(By.xpath("//div[@data-name='Subtotals']")).getText();
    System.out.println("Product details: "+details);    
    }
}

