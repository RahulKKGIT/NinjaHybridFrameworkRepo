package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {

	WebDriver driver;
	
	public Searchpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="HP LP3065")
	private WebElement validHPproduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	public boolean displayStatusOfHPproduct() {
		
		boolean displayStatus = validHPproduct.isDisplayed();
		return displayStatus;
	}
	public String retrieveNoProductMessageText() {
		
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}
	
}
