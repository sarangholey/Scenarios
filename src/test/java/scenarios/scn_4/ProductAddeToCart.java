package scenarios.scn_4;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAddeToCart {
	
	
    @Test
    
    public void Assignment5() throws InterruptedException {
    	
    WebDriver driver=new ChromeDriver();
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String Expected_ttle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    System.out.println("the page title is : "+driver.getTitle());
    Assert.assertEquals(Expected_ttle,driver.getTitle());
    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bottle");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
   List <WebElement> Product_List=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
    System.out.println(" No Of Product_List size is:" +Product_List.size());
    
   
    for(int i=0;i<3; i++)
    {
    	
    	Product_List=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
    
    	Product_List.get(i).click();
    Thread.sleep(3000);
    Set<String> ids=driver.getWindowHandles();	
	Iterator<String> it=ids.iterator();
    String parentid=it.next();
    String childid= it.next();
	driver.switchTo().window(childid);
	
    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
    Thread.sleep(3000);
    driver.close();
    driver.switchTo().window(parentid);
    driver.navigate().refresh();
    }
    driver.findElement(By.id("nav-cart")).click();
    List<WebElement> added_Items=driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
    System.out.println("AddedItems:"+added_Items.size());
    for(int j=0;j<3;j++)
    {
    	added_Items=driver.findElements(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
    	String all_product=added_Items.get(j).getText();
    	System.out.println("crtDetails:"+all_product);
    	
    }
    
    }
        
    	
    	
    	
    	

}
