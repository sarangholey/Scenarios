package scenarios.scn_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scenario1 {

	@Test
	public void assignment1()
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/mobile-apps");
			
		driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			WebElement searchBox=driver.findElement(By.xpath("//input[@class='LM6RPg']"));
			searchBox.clear();
			
			System.out.println("dispaly search Box:"+searchBox.isDisplayed());

			searchBox.sendKeys("oneplus");
			
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")).click();
			
			List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='_1vC4OE']"));
			
			int T_prc=allprice.size();
			
			for(int i=0;i<T_prc;i++) {
				
		String replace=allprice.get(i).getText().replace("₹", "").replace(",", "");  //for removing rupees symbol
				
		int count=Integer.parseInt(replace);

		int price=0;

		price=price+count;
				
		System.out.println(price);
				
				
				
			}
			
				
    
}


	}

