package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.Interact;

public class ScenarioObject_4 extends Interact
{
	private static final Logger logger = LogManager.getLogger(ScenarioObject_4.class);
	Scenario scn;
	
	   String product_1;
	   String product_2;
	   String product_3;

	private By amazon_title = By.xpath("//div[@id='nav-logo']");
	private By search_text_box= By.xpath("//input[@id='twotabsearchtextbox']");
	private By fetch_all_product=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By add_to_cart_button=By.xpath("//input[@id='add-to-cart-button']");
	private By cart_product_list=By.xpath("//p[@class='a-spacing-small']");
	private By cart_link=By.xpath("//a[@id='nav-cart']");

	public ScenarioObject_4(WebDriver driver, Scenario s) 
	{
		setDriver(driver);
		this.scn = s;
	}
	public void validateAmazonTitle()
	{
		Assert.assertTrue(validateElementIsDisplayed(amazon_title));		
		logger.info("Amazon Title is Displayed");
	}
	
	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		logger.info("Value enetered in search box: " + text);
		setElement(search_text_box,Keys.ENTER);		
	}
	public List<String> AddProductsToCart()
	{
		List<String> cartAddedProductName = new ArrayList<>();
		List<WebElement> ProductName=getListOfWebElements(fetch_all_product);
		logger.info("elements list: " + ProductName);
		for(int i=0;i<=ProductName.size();i++)
		{
			String selectProuct =ProductName.get(i).getText();
			cartAddedProductName.add(selectProuct);
			logger.info("Producr name: " + selectProuct);
			ProductName.get(i).click();
			waitForLoad(5000);
			String winHandleBefore =  getDriver().getWindowHandle();
			for (String handle1 : getDriver().getWindowHandles()) {
				 logger.info(handle1);
				 getDriver().switchTo().window(handle1);
	        }
			waitForLoad(5000);
			clickElement(add_to_cart_button);
			waitForLoad(4000);
			getDriver().close();
			// Switch back to original browser (first window)
			getDriver().switchTo().window(winHandleBefore);
			if(i==2)
			{
				refreshWebPage();
				break;
			}
			
		}
		return cartAddedProductName;
	}
	
	public List<String> GetCartProductList() {
		clickElement(cart_link);
		List<WebElement> list = getListOfWebElements(cart_product_list);
		logger.info("Cart list" + list);
	     product_1=list.get(0).getText();
	     logger.info("first product:  " + product_1);
		 product_2=list.get(1).getText();
		 logger.info("second product:  " + product_2);
		 product_3=list.get(2).getText();
		 logger.info("third product:  " + product_3);	
		 return Arrays.asList(product_3, product_2, product_1);
	}
	 
	public void validateCartItemSequence()
	{
		List<String> productNameBeforeAddToCart=AddProductsToCart();
		List<String> productNameAfterAddToCart=GetCartProductList();
		boolean isEqual = productNameBeforeAddToCart.equals(productNameAfterAddToCart);
		Assert.assertTrue(isEqual);
	}
}
	



