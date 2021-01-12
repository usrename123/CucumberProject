package com.zoopla.qa.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POhomePage {
	public POhomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	WebElement Accept_Cookies;
	@FindBy(xpath ="//div[@class='search-input-wrapper']//input[@id='search-input-location']")
	WebElement SearchBox;
	@FindBy(xpath = "//h1[contains(text(),'Property for sale in London')]")
	WebElement Title;
	@FindBy(xpath = "//button[@id='search-submit']")
	WebElement SubmittButton;


	

	public void ufSendKeys(WebDriver driver, WebElement ele, String keysToSend)
			throws Exception {
		
		ufSendKeys(driver, ele, keysToSend);
	}



	public void ufClick_acceptCookies(WebDriver driver, WebElement ele) throws Exception {
		ufClick_acceptCookies(driver, Accept_Cookies);
	}
	public void TitleValidation(){
		//String actual_title=driver.getTitle();
		String expected_title="Search Property to Buy, Rent, House Prices, Estate Agents";
		//Assert.assertTrue(actual_title.contains(expected_title));
		
	}

}
