package scenarios.scn_3;

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
    System.out.println("SearchBox is displays: "+SearchBox.isDisplayed());
    SearchBox.sendKeys("samsung mobiles");
    driver.findElement(By.xpath("//button[@class='vh79eN']")).click();
    
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
    driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();;
    
    Thread.sleep(3000);
    WebElement LowerPriceProduct= driver.findElement(By.xpath("//div[text()='Samsung Galaxy J4 (Gold, 16 GB)']"));
    WebElement MinPriceOfMobile=driver.findElement(By.xpath("//div[text()='₹10,903']"));
    System.out.println("LowerPriceMobile Name is: "+LowerPriceProduct.getText());
    System.out.println("PriceOfMobile is: "+MinPriceOfMobile.getText());
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
    
    Thread.sleep(3000);
    WebElement HigherPriceProduct=driver.findElement(By.xpath("//div[text()='Samsung Galaxy A8 Plus (Gold, 64 GB)']"));
    WebElement MaxPriceOfMobile=driver.findElement(By.xpath("//div[text()='₹30,000']"));
    System.out.println("HigherPriceMobile Name is: "+HigherPriceProduct.getText());ystem.out.println("MaxPriceOfMobile is: "+MaxPriceOfMobile.getText());
    }
}
