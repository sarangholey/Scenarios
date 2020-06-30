package scenarios.scn_1.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPageObjects extends Interact{

	private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);
	Scenario scn;
	int Result=0;
	
	private By close_btn = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By search_text_box = By.xpath("//input[@class='LM6RPg']");
	private By search_box = By.xpath("//button[@class='vh79eN']");
	private By list_of_price = By.xpath("//div[@class='_1vC4OE']");
	
	public SearchPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
	}
	
	public void ClickOnCloseBtn() {
		clickElement(close_btn);
	}
	
	public void SetSearchTextBox(String text) {
		boolean b=validateElementIsDisplayed(search_text_box);
		if(b) {
			System.out.println("Shearch box is displayed");
			Assert.assertEquals(true, b);
		}else {
			System.out.println("Shearch box is not displayed");
		}
		setElement(search_text_box,text);
	}
	
	public void ClickOnSearchBox() {
		clickElement(search_box);
	}
	
	public void FetchAllThePricesPresentOnFirstPage() {
		List<WebElement> price_list = getListOfWebElements(list_of_price);
		for(int i=0;i<price_list.size();i++) {
			System.out.println("product price:- "+ price_list.get(i).getText().replace("₹", ""));	
		}		
	}
		
	public void SumAllThePricesPresentOnFirstPg() {
		List<WebElement> price_list = getListOfWebElements(list_of_price);
		for(int i=0;i<price_list.size();i++) {
			try {
			String str=price_list.get(i).getText().replace("₹", "");
			String strNew=str.replace(",", "");
			Result=Integer.parseInt(strNew)+Result;
			}catch(NumberFormatException ex) {
				System.out.println("Exception occured: "+ex.getMessage());
			}
		}
		System.out.println("sum of all the prices present on the first page is: "+Result);
	}
	
}
