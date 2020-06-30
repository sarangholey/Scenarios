package scenarios.scn_1;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FetchPrices
{
	 WebDriver driver;
	 WebDriverWait wait;
	@Test
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\visionit\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.flipkart.com/");
		//Reporter.log("Opn chrome and navigated to URL: " + url + "<br>", true);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.manage().window().maximize();
		
		  Actions actions =new Actions(driver);
		  Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		  sendEsc.perform();  	
		  
		  /*  String actual = driver.getTitle();
			String expected = "Flipkart";
			Assert.assertEquals(actual, expected);
			Reporter.log("Page Navigated." + "<br>", true);*/
		  
	    boolean isDisplayed = driver.findElement(By.xpath("//img[@title='Flipkart']")).isDisplayed();
		  if(isDisplayed) {
		System.out.println("Title is validated succesfully");  
		  }
		  else {
		System.out.println("Title is not validated succesfully");
	           }
	  //search
	  wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search for products, brands and more']"))).sendKeys("Oneplus");
	
	  //click on search btn
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
     
     try {
    	 Thread.sleep(3000);
     } catch(InterruptedException e) {
    	 //auto generate catch block
    	 e.printStackTrace();		
     }
     
     List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class='_1HmYoV _35HD7C']//div[@class='_1vC4OE']"));
		int size = productsPrice.size();
		System.out.println(size);
		int total = 0;
		int t = 1;
		for(int i = 1; i < size; i++) {
			String price = productsPrice.get(i).getText().replace("₹","").replace(",","");
			int p = Integer.parseInt(price);
			System.out.println("Product : " +  i + " Price :" + p);
			total = total + p;
		}
		System.out.println("\nTotal of all product prices: " + total);
		driver.quit();
	}
}

/*
String xpathNoRows="//*[@class='bhgxx2 col-12-12']/div";

List<WebElement> listTotal = driver.findElements(By.xpath(xpathNoRows));
System.out.println("Total No. of Rows"+listTotal.size());
*/
