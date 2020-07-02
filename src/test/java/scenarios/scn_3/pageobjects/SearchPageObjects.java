package scenarios.scn_3.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class SearchPageObjects extends Interact{

	private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);
	Scenario scn;
	private WebDriver driver;
	int Result=0;

	private By close_btn = By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By search_text_box = By.xpath("//input[@class='LM6RPg']");
	private By search_box = By.xpath("//button[@class='vh79eN']");
	private By min_price = By.xpath("//select[@class='fPjUPw']//option[@value='Min']");
	private By max_price = By.xpath("//select[@class='fPjUPw']//option[@value='Max']");
	private By select_min_price = By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']");
	private By select_max_price = By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']");
	private By select_min_price_pro = By.xpath("//div[@data-id='MOBFRZZHRFVXDUZZ']//div[@class='_3wU53n']");
	private By select_max_price_pro = By.xpath("//div[@data-id='MOBFS72HDJXVHAYP']//div[@class='_3wU53n']");
	
	public WebDriver getDriver() {
		 return driver;
	}
	
	public SearchPageObjects(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
		this.driver=driver;
	}
	
	public void ValidatePageTitle() {
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	    String actualTitle=driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
	    scn.write("Page title:- "+expectedTitle);
	}

	public void ClickOnCloseBtn() {
		clickElement(close_btn);
	}

	public void SetSearchTextBox(String text) {
		boolean b=validateElementIsDisplayed(search_text_box);
		if(b) {
			scn.write("Shearch box is displayed");
			Assert.assertEquals(true, b);
		}else {
			scn.write("Shearch box is not displayed");
		}
		setElement(search_text_box,text);
	}

	public void ClickOnSearchBox() {
		clickElement(search_box);
	}
	
	public void ValidateFilterDropdownBoxPresent(){
		boolean min = validateElementIsDisplayed(min_price);
		if(min) {
			scn.write("Dropdown for minimum value of filter is displayed");
		}else {
			scn.write("Dropdown for minimum value of filter is not displayed");
		}		
		
		boolean max = validateElementIsDisplayed(max_price);
		if(max) {
			scn.write("Dropdown for maximum value of filter is displayed");
		}else {
			scn.write("Dropdown for maximum value of filter is not displayed");
		}		
	}

	public void SelectMinAndMaxRangeForTheProduct() throws InterruptedException {
		selectDropdown(select_min_price,"10000");
		Thread.sleep(10000);
		selectDropdown(select_max_price,"30000");	
	}

	public void PrintlowestAndHighestPriceProductFromUpdatedList() {
		String minimumPriceProduct = getText(select_min_price_pro);
		scn.write("Lowest price product name:-"+minimumPriceProduct);
		
		String maximumPriceProduct = getText(select_max_price_pro);
		scn.write("Highest price product name:-"+maximumPriceProduct);
	}
	
}
