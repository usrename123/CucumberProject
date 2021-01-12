package com.stepDefinationfiles;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.zoopla.qa.Pages.POhomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageStepdefination {
	static WebDriver driver;
	POhomePage Pohome = new POhomePage(driver);


	static WebElement dropdown;

	@Given("user is on home page")
	public void user_is_on_home_page() throws Exception {

		System.out.println("usre can see the homepage");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.zoopla.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")).click();
		Thread.sleep(3000);


	}

	@When("click on the searchbox")
	public void click_on_the_searchbox() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.cssSelector(
				"body.layout-fullbleed.brand-zoopla:nth-child(2) div.main-content-area.clearfix:nth-child(8) div.clearfix div.layout-fullbleed div.search-home-reskin:nth-child(1) div.search-home-reskin__wrapper.search-home-reskin__wrapper--image2 div.search-home div.search.search-home.wrap.search-section-for-sale.search-type-search.overseas-hero- form:nth-child(2) div.search-wrapper-inner div.search-top:nth-child(1) div.search-input-wrapper > span.search-input-location-placeholder"));
		searchbox.click();

		Thread.sleep(8000);

	}

	@When("send keys")
	public void send_keys() {
		System.out.println("location has been entered manually");
	}

	@Then("navigate to next page1")
	public void navigate_to_next_page1() {
		driver.findElement(By.xpath("//button[@id='search-submit']")).click();

	}

	@Given("click on dropDown")
	public void click_on_drop_down() throws InterruptedException {

		dropdown=driver.findElement(By.xpath("//select[@id='sort-order-dropdown']"));
		dropdown.click();
		Thread.sleep(4000);

	}

	@When("select the highest Price")
	public void select_the_highest_price() throws InterruptedException {
		Select s=new Select(dropdown);
		s.selectByValue("highest_price");
		Thread.sleep(5000);

	}

	@Then("displays all the props decending from highest price")
	public void displays_all_the_props_decending_from_highest_price() {
		List<WebElement>listings=driver.findElements(By.xpath("//p[@class='css-18tfumg-Text eczcs4p0']")); 

		List<WebElement>HigherPrice=listings;

		System.out.println(HigherPrice.size());

		for(int i=0;i<HigherPrice.size();i++) {

			System.out.println("Price Of Property is :" + HigherPrice.get(i).getText());
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}

	}

	@Given("property info is open")
	public void property_info_is_open() {

		System.out.println("Property listing is open");	

	}

	@When("select the fifth prop and click")
	public void select_the_fifth_prop_and_click() throws InterruptedException {
		WebElement fifthProp=driver.findElement(By.xpath("//body/div[@id='__next']/div[4]/div[1]/main[1]/div[2]/div[2]/div[5]/div[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fifthProp);
		fifthProp.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("opened the next page")
	public void opened_the_next_page() {
		System.out.println("User can see the listing page");
	}

	@Then("validate the agent")
	public void validate_the_agent() {
		WebElement AgentInfo=driver.findElement(By.xpath("//body/main[@id='main-content']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]"));
		String AgentNameOn_clickedPage="Panther International Properties";
		String AgentInfo_validation=AgentInfo.getText();
		System.out.println("Actual Agent name on the page is: "+AgentInfo_validation);
		Assert.assertTrue(AgentInfo_validation.contains(AgentNameOn_clickedPage));
		driver.quit();
	}

}
