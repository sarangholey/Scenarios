package pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.Scenario;
import utils.Interact;

public class ScenarioObject_5 extends Interact
{
	private static final Logger logger = LogManager.getLogger(ScenarioObject_5.class);
	Scenario scn;
	
	private By footer_link_value =By.xpath("//div[@id='navFooter']//a");
	
	public ScenarioObject_5(WebDriver driver, Scenario s)
	{
		setDriver(driver);
		this.scn = s;
	}
	
	public void GetAllLinkAndPrint()
	{
		WebElement footerValues=getDriver().findElement(footer_link_value);
		List<WebElement>  linklist= getListOfWebElements(footer_link_value);
		logger.info("Link list is " + linklist );
		for(int i=0;i<=linklist.size();i++)
		{
			footerValues=getDriver().findElement(footer_link_value);
			footerValues.findElements(footer_link_value).get(i).click();
	      logger.info(getDriver().getTitle());
	        
			getDriver().navigate().back();
			waitForLoad(4000);
		}
			}
	
	
}
