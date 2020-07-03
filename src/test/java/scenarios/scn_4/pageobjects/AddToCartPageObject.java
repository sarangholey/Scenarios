package scenarios.scn_4.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import utils.ui.Interact;

public class AddToCartPageObject extends Interact{

	private static final Logger logger = LogManager.getLogger(AddToCartPageObject.class);
	Scenario scn;
	private WebDriver driver;

	private By search_text_box = By.id("twotabsearchtextbox");
	private By search_button = By.xpath("//input[@value='Go']");
	private By product_list_all = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By add_to_cart_btn = By.xpath("//input[@id='add-to-cart-button']");
	private By cart_btn = By.xpath("//a[@class='nav-a nav-a-2']");  
	private By list_of_products_in_cart = By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");

	public WebDriver getDriver() {
		return driver;
	}

	public AddToCartPageObject(WebDriver driver, Scenario s) {
		setDriver(driver);
		this.scn = s;
		this.driver=driver;
	}

	public void ValidatePageTitle() {
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		scn.write("Page title:- "+expectedTitle);
	}

	public void SetSearchTextBox(String text) {
		setElement(search_text_box, text);
		logger.info("Value enetered in search box: " + text);
		takeScreenShotAndAttachInReport(scn);
	}

	public void ClickOnSearchButton() {
		clickElement(search_button);	
		logger.info("Clicked on Search Button");
	}

	public void ClearSearchTextBox() {
		clearElementText(search_text_box);	
		logger.info("Search Text Box is cleared");
	}

	public String ClickOnProductLink() {
		List<WebElement> list = getListOfWebElements(product_list_all);
		clickElement(list.get(0));
		scn.write("Clicked on First Product Link");
		return list.get(0).getText();
	}

	public void ClickOnAddToCartBtn() {
		clickElement(add_to_cart_btn);
		scn.write("Clicked on Add To Cart Button");
		logger.info("Clicked on Add To Cart Button");	
	}

	public void ClickOnCartBtn() {
		clickElement(cart_btn);
		scn.write("Clicked on Cart Button present in Header section");
		logger.info("Clicked on Cart Button present in Header section");	
	}

	public void ValidateFirstProduct(String proName3) {
		List<WebElement> list_product = getListOfWebElements(list_of_products_in_cart);
			String list_1=list_product.get(0).getText();	
			String list_2=proName3;
			if(list_1.equals(list_2)) {
				Assert.assertTrue(true);
				scn.write("Shopping cart contains list of products as: "+list_1);
			}else {
				Assert.fail("Product sequence is not correct");
			}
	}
	
	public void ValidateSecondProduct(String proName2) {
		List<WebElement> list_product = getListOfWebElements(list_of_products_in_cart);
			String list_1=list_product.get(1).getText();	
			String list_2=proName2;
			if(list_1.equals(list_2)) {
				Assert.assertTrue(true);
				scn.write("Shopping cart contains list of products as: "+list_1);
			}else {
				Assert.fail("Product sequence is not correct");
			}
	}
	
	public void ValidateThirdProduct(String proName1) {
		List<WebElement> list_product = getListOfWebElements(list_of_products_in_cart);
			String list_1=list_product.get(2).getText();	
			String list_2=proName1;
			if(list_1.equals(list_2)) {
				Assert.assertTrue(true);
				scn.write("Shopping cart contains list of products as: "+list_1);
			}else {
				Assert.fail("Product sequence is not correct");
			}
	}

}
