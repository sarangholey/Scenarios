package scenarios.scn_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public class PageObjectModel extends Util {

	Scenario scn;
	String product_1;
	String product_2;
	String product_3;
	
	private By search_box=By.name("q");
	private By search_button=By.xpath("//button[@class='vh79eN']");
	private By login_pop_up=By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By mobile_cost=By.xpath("//div[@class='_1HmYoV hCUpcT']//div[@class='_1vC4OE']");
	private By autosuggestion_list=By.xpath("//li[@class='_1va75j']");
	private By select_min_cost=By.xpath("//div[@class='_1qKb_B']//option[@value='10000']");
	private By select_max_cost=By.xpath("//div[@class='_1YoBfV']//option[@value='30000']");
	private By min_cost_dropdown=By.xpath("//div[@class='_1qKb_B']");
	private By max_cost_dropdown=By.xpath("//div[@class='_1YoBfV']");	
	private By list_of_product=By.xpath("//div[@class='_3wU53n']");
	private By list_of_price=By.xpath("//div[@class='_1vC4OE _2rQ-NK']");
	private By low_high_price_link=By.xpath("//div[@class='_1xHtJz xufquN']");
	private By product_list=By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	private By add_to_cart_button= By.id("add-to-cart-button");
	private By cart_link = By.id("nav-cart");
	private By cart_product_list=By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']");
	private By footer_link=By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']//li//a[@class='nav_a']");

	public PageObjectModel(WebDriver driver, Scenario scn) {
		this.scn=scn;
		setDriver(driver);
	}

	public void ValidateTitle( String actual_title) {
		String expected_title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		assertEquals(expected_title, actual_title);
		scn.write("Title is validated");
	}

	public void ClickOnLoginPopUp() {
		clickElement(login_pop_up);
	}
	public void SearchProduct(String product_name) {
		setElement(search_box, product_name);
		clickElement(search_button);
	}

	public void SetProductInSearchBox(String productName) {
		setElement(search_box, productName);
	}

	public void ValidateSearchBox() {
		boolean b= validateElementIsDisplayed(search_box);
		if (b) {
			assertTrue("SearchBox is displayed", true);
		}else {
			Assert.fail("Serach Box is not displayed");
		}
	}

	public void TotalCostOfAllProduct() {
		List<WebElement> eachProductCost=getDriver().findElements(mobile_cost);
		int count=eachProductCost.size();
		String splitCost=null;
		int totalCost=0;
		System.out.println("Total product available on first page are: "+count);
		for(int i=0;i<eachProductCost.size();i++) {
			String stringCost=eachProductCost.get(i).getText();
			for(String s:stringCost.split("₹")) {
				splitCost=s;
			}
			String actualCost=splitCost.replace(",","");
			int IntgerCost=Integer.parseInt(actualCost);
			totalCost=totalCost+IntgerCost;
		}
		System.out.println("Total cost of all the products : "+totalCost);
	}

	public void ValidateDropDownSuggestion(String productName) {
		List<WebElement> list=getListOfAllElements(autosuggestion_list);
		for(int i=0;i<list.size();i++) {
			String autoSuggestionList=list.get(i).getText();
			if(autoSuggestionList.toLowerCase().contains(productName.toLowerCase())) {
				System.out.println(productName+" keyword is displayed in autosuggestion dropdown at index no: "+i+" with name : "+autoSuggestionList);
			}
			else {
				System.out.println(productName+" keyword is not displayed in autosuggestion dropdown at index no: "+i);
			}
		}
	}

	public void SelectMinCost() {
		clickElement(select_min_cost);
	}

	public void SelectMaxCost() {
		clickElement(select_max_cost);
	}

	public void ValidateMinCostDropDown() {
		boolean b=validateElementIsDisplayed(min_cost_dropdown);
		if(b) {
			System.out.println("Min price dropdown is displayed");
			Assert.assertEquals(true, b);
		}else {
			System.out.println("Min price dropdown not displayed");
		}
	}

	public void ValidateMaxCostDropDown() {
		boolean b=validateElementIsDisplayed(max_cost_dropdown);
		if(b) {
			System.out.println("Max price dropdown is displayed");
			Assert.assertEquals(true, b);
		}else {
			System.out.println("Max price dropdown not displayed");
		}
	}

	public void GetTheHighestAndLowestPriceOfCommodity() throws InterruptedException {

		List<WebElement> eachProductPrice=getListOfAllElements(list_of_price);	
		ArrayList<Integer> a1=new ArrayList<Integer>();
		for(int i=0;i<eachProductPrice.size();i++) {
			String cost=eachProductPrice.get(i).getText().substring(1).replaceAll(",", "");
			int expectedCost=Integer.parseInt(cost);
			a1.add(expectedCost);
			System.out.println(expectedCost);
			eachProductPrice=getListOfAllElements(list_of_price);
		}
		Collections.sort(a1);
		int lowestPrice=a1.get(0);
		int highestPrice=a1.get(a1.size()-1);
		List<WebElement> eachProductName=getListOfAllElements(list_of_product);
		clickElement(low_high_price_link);
		for(int i=0;i<eachProductName.size();i++) {
			String cost=eachProductPrice.get(i).getText().substring(1).replaceAll(",", "");
			int actualCost=Integer.parseInt(cost);
			String productName=eachProductName.get(i).getText();
			if(lowestPrice==actualCost) {
				System.out.println(productName+" is the lowest price price product with price : "+lowestPrice);
			}
			else if(highestPrice==actualCost) {
				System.out.println(productName+" is the highest price price product with price : "+highestPrice);
			}
			eachProductName=getListOfAllElements(list_of_product);
			eachProductPrice=getListOfAllElements(list_of_price);
		}
	}

	public void ValidateAmazonTitle( String actual_title) {
		String expected_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		assertEquals(expected_title, actual_title);
		scn.write("Title is validated");
	}

	public String ClickOnProductLink(int productIndex) {
		List<WebElement> list = getListOfWebElements(product_list);
		clickElement(list.get(productIndex));
		scn.write("Clicked on Product id: " + productIndex + " Product Link");
		return list.get(productIndex).getText();
	}

	public void AddProductToCart(){
		clickElement(add_to_cart_button);
	}

	public void CartMenu()	{
		clickElement(cart_link);
	}

	public void GetCartProductList() {
		List<WebElement> list = getListOfWebElements(cart_product_list);
		product_1=list.get(0).getText();
		product_2=list.get(1).getText();
		product_3=list.get(2).getText();		
	}

	public void ValidateCartProduct1Sequence(String productName) {
		assertEquals(productName, product_1);
	}

	public void ValidateCartProduct2Sequence(String productName) {
		assertEquals(productName, product_2);
	}
	public void ValidateCartProduct3Sequence(String productName) {
		assertEquals(productName, product_3);
		System.out.println(" Sequence of products is validate");
	}

	public void ClickLinkAndFetchTitle() {
		List<WebElement> list=getListOfAllElements(footer_link);
		for(int i=0;i<list.size();i++) {
			clickElement(list.get(i));
			String getTitle=getDriver().getTitle();
			System.out.println(getTitle);
			getDriver().navigate().back();
			list=getListOfAllElements(footer_link);
		}

	}
}
