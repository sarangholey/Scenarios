package context;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import pageobjects.ScenarioObjects_1;

public class TestContext {
	private WebDriver driver;
	private ScenarioObjects_1 scenarioObjects_1;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public ScenarioObjects_1 getScenarioObjects_1() {
		return scenarioObjects_1;
	}
	
	public void initializePageObjectClasses(WebDriver driver,Scenario scn) {
		scenarioObjects_1 = new ScenarioObjects_1(driver,scn);
		
	}


}
