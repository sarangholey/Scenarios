package pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;
import utils.Interact;

public class ScenarioObject_3 extends Interact 
{
	private static final Logger logger = LogManager.getLogger(ScenarioObject_3.class);
	Scenario scn;
	
	private By Minimum_price= By.xpath("//div[@class='_1qKb_B']");
	private By Maximum_price = By.xpath("//div[@class='_1YoBfV']");
	private By Minimum_price_dropdown=By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']");
	private By Maximum_price_dropdown=By.xpath("//div[@class='_1YoBfV']//select[@class='fPjUPw']");
	private By Lowest_price_commodity=By.xpath("//div[text()='Price -- Low to High']");
	private By Lowset_product_price_name=By.xpath("//*[@Class='_31qSD5']//div[@Class='_3wU53n']");
	private By Lowest_product_price=By.xpath("//*[@Class='_31qSD5']//div[@class='_1vC4OE _2rQ-NK']");
	private By Highest_price_commodity=By.xpath("//div[text()='Price -- High to Low']");
	private By Highest_product_price_name=By.xpath("//*[@Class='_31qSD5']//div[@Class='_3wU53n']");
	private By Highest_product_price=By.xpath("//*[@Class='_31qSD5']//div[@class='_1vC4OE _2rQ-NK']");
	public ScenarioObject_3(WebDriver driver, Scenario s) 
	{
		setDriver(driver);
		this.scn = s;
	}
	
	public void fetchMinimumValue()
	{
		clickElement(Minimum_price);
		Assert.assertTrue(validateElementIsDisplayed(Minimum_price));
		selectValueFromDropDown(Minimum_price_dropdown,"10000");
		
	}
	public void fetchMaximumValue() 
	{
		waitForLoad(3000);
		clickElement(Maximum_price);
		Assert.assertTrue(validateElementIsDisplayed(Maximum_price));
		selectValueFromDropDown(Maximum_price_dropdown,"30000");
		
	}
	
	public void lowestPriceProduct()
	{
		waitForLoad(6000);
		clickElement(Lowest_price_commodity);
		waitForLoad(4000);
		String lpProductName=getText(Lowset_product_price_name);
		logger.info("Low price pro name is" + lpProductName);
		String lpProductPrice=getText(Lowest_product_price);
		logger.info("Low price pro ammount is" + lpProductPrice);
	
	}
	
	public void highPriceProduct()
	{
		waitForLoad(6000);
		clickElement(Highest_price_commodity);
		waitForLoad(5000);
		String hiProductName=getText(Highest_product_price_name);
		logger.info("High price pro name is" + hiProductName);
		String hiProductPrice=getText(Highest_product_price);
		logger.info("High price pro ammount is" + hiProductPrice);
	
	}
}
