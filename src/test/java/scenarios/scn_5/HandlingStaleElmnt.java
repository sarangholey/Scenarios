package scenarios.scn_5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HandlingStaleElmnt {
	WebDriver driver;

	@Given("I have browser opened and url is navigated to {string} and validate titleeeeee")
	public void i_have_browser_opened_and_url_is_navigated_to_and_validate_titleeeeee(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}

	@When("I go the footer Section click on the each link fetch the title of the page and print on Console, go back on the main page and do same step for all the links")
	public void i_go_the_footer_Section_click_on_the_each_link_fetch_the_title_of_the_page_and_print_on_Console_go_back_on_the_main_page_and_do_same_step_for_all_the_links() {

		List<WebElement> footerElements = driver.findElements(By.xpath(
				"//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']//td[@class='navFooterDescItem']//a[@class='nav_a']"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Element Size is:" + footerElements.size());
		for (int i = 0; i < footerElements.size(); i++) {

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			footerElements = driver.findElements(By.xpath(
					"//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']//td[@class='navFooterDescItem']//a[@class='nav_a']"));

			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(footerElements.get(i))).click();

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			System.out.println(driver.getTitle());
			driver.navigate().back();

		}
	}

}
