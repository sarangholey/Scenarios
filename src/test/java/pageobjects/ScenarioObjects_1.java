package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.Interact;



public class ScenarioObjects_1 extends Interact  {
	private static final Logger logger = LogManager.getLogger(ScenarioObjects_1.class);
	Scenario scn;

	private By search_text_box = By.xpath("//input[@name='q']");
	private By filpkart_title = By.xpath("//*[@id='container']//a[1]/img[@title='Flipkart']");
	private By search_button = By.xpath("//button[@type='submit']");
	private By login_cancel_button=By.xpath("//button[text()='✕']");
	private By price_of_all_product=By.xpath("//div[@class='_1vC4OE']");
	
	public ScenarioObjects_1(WebDriver driver, Scenario s) 
	{
		setDriver(driver);
		this.scn = s;
	}
	
	public void CancelButton()
	{
		logger.info("hi4");
		clickElement(login_cancel_button);
		logger.info("Clicked on Cancel Button");
	}
	/*public String get_text()
	{
		String textValue=getText(get_text_value);
		logger.info("Cart Product Value:"+textValue);		
		return textValue;	 
	}*/
	public void validateFilpkartTitle()
	{
		Assert.assertTrue(validateElementIsDisplayed(filpkart_title));		
		logger.info("Flipkart Title is Displayed");
	}
	
	public void validateSearchBoxTitle()
	{
		Assert.assertTrue(validateElementIsDisplayed(search_text_box));
		logger.info("Sreach box visible");
	}
	
	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		logger.info("Value enetered in search box: " + text);
		
	}

	public void ClickOnSearchButton() {
		clickElement(search_button);	
		logger.info("Clicked on Search Button");
	}
	
	public void fetchAllProductPrice()
	{
		int Price=0;
		List<WebElement> ProductPrice=getListOfWebElements(price_of_all_product);	
		logger.info("elements list: " + ProductPrice);
		for(int i=0; i<ProductPrice.size();i++)
		{
			int value =Integer.parseInt(ProductPrice.get(i).getText().replaceAll("[^0-9]", ""));
			logger.info("price of element: " + value);
			//Price = Price + value;
			Price += value;
		}
		logger.info("All product some:"+Price);
	}

}
