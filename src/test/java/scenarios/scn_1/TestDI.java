package scenarios.scn_1;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class TestDI {

	private WebDriver driver;
	private PageObjectModel pm;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public PageObjectModel getPm() {
		return pm;
	}

	public void GetInstanceOfPageObject(WebDriver driver,Scenario scn) {
		pm=new PageObjectModel(driver,scn);
	}
}

