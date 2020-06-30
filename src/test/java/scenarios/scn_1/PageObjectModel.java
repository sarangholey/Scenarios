package scenarios.scn_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;

public class PageObjectModel extends Util {

	Scenario scn;
    private By search_box=By.name("q");
	private By search_button=By.xpath("//button[@class='vh79eN']");
	private By login_pop_up=By.xpath("//button[@class='_2AkmmA _29YdH8']");
	private By mobile_cost=By.xpath("//div[@class='_1HmYoV hCUpcT']//div[@class='_1vC4OE']");

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

}
