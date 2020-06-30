package scenarios.scn_1.context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import scenarios.scn_1.pageobjects.SearchPageObjects;


public class TextContext {

	private WebDriver driver;
	private SearchPageObjects searchPageObjects;
	
	public WebDriver getDriver() {
		return driver;
	}
	
    public void setDriver(WebDriver driver) {
			this.driver=driver;
		}
		
    public SearchPageObjects getSearchPageObjects() {
			return searchPageObjects;
	    }
	    
    public void InitializePageObjectClasses(WebDriver driver,Scenario scn) {
	    	searchPageObjects=new SearchPageObjects(driver,scn);
	    }
}
