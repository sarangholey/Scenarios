package scenarios.scn_4.context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import scenarios.scn_4.pageobjects.AddToCartPageObject;


public class TextContext {

	private WebDriver driver;
	private AddToCartPageObject addToCartPageObject;
	
	public WebDriver getDriver() {
		return driver;
	}
	
    public void setDriver(WebDriver driver) {
			this.driver=driver;
		}
		
    public AddToCartPageObject getAddToCartPageObject() {
			return addToCartPageObject;
	    }
	    
    public void InitializePageObjectClasses(WebDriver driver,Scenario scn) {
    	addToCartPageObject=new AddToCartPageObject(driver,scn);
	    }
}
