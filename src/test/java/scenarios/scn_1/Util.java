package scenarios.scn_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver d) {
		this.driver=d;
	}

	public WebElement clickElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));//locator-return type
		element.click();
		return element;
	}

	public WebElement setElement(By by, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
		return element;
	}

	public boolean validateElementIsDisplayed(By by) {
		boolean b = driver.findElement(by).isDisplayed();
		return b;
	}

	public List<WebElement> getListOfAllElements(By by){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.findElements(by);
	}

	public void clickElement(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}


	public List<WebElement> getListOfWebElements(By by){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element.findElements(by);
	}

}
