package scenarios.scn_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {
    WebDriver driver;
    String url="https://www.flipkart.com/";
    String title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
    String Min="10000";
    String Max="30000";
    @Test
    public void MethodAssignment3() throws InterruptedException {
    WebDriver driver=new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    System.out.println("Page title is: "+driver.getTitle());
    Assert.assertEquals(title,driver.getTitle());
    
    driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();	
	
    WebElement SearchBox =driver.findElement(By.xpath("//input[@class='LM6RPg']"));
    boolean v=SearchBox.isDisplayed();
   	if (v) {
   	Assert.assertTrue("SearchBox is visible",true);}
   	else {
   	Assert.fail("SearchBox is not visible");}
    SearchBox.sendKeys("samsung mobiles");
    
    driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
    Thread.sleep(3000);
    WebElement MinPrice=driver.findElement(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']"));
    System.out.println("MinPrice is visible: "+MinPrice.isDisplayed());
    WebElement MaxPrice=driver.findElement(By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']"));
    System.out.println("Maxprice is visible: "+MaxPrice.isDisplayed());
    Thread.sleep(3000);
    
    Select Dropdown=new Select(MinPrice);
    Dropdown.selectByValue(Min);
    WebElement LowerPrice=driver.findElement(By.xpath("//div[@class='_1qKb_B']//option[@value='10000']"));
    System.out.println("SelectedMinPrice: "+LowerPrice.getText());
    Thread.sleep(3000);
    
    Select Dropdown2=new Select(MaxPrice);
    Dropdown2.selectByValue(Max);
    WebElement HigherPrice=driver.findElement(By.xpath("//div[@class='_1YoBfV']//option[@value='30000']"));
    System.out.println("SelectedMaxPrice: "+HigherPrice.getText());
    
    Thread.sleep(3000);
    List<WebElement>list=driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
	ArrayList<Integer> Array=new ArrayList<Integer>();
    for(int i=0;i<list.size();i++) 
    {
     String product=list.get(i).getText();   
     String remove=product.replace("₹","").replace(",","");
     int convertprice=Integer.parseInt(remove);
     System.out.println(convertprice);
     Array.add(convertprice);
     Integer max = Collections.max(Array);  
     System.out.println(max);
    }
    System.out.println("max"+Collections.max(Array,null));
    System.out.println("min"+Collections.min(Array,null));
    }
   }
   
