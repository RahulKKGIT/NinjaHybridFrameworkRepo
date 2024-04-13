package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accountSuccessMessage;
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String retrieveAccountSuccessText() {
		
		String accountSuccessPageText = accountSuccessMessage.getText();
		return accountSuccessPageText;
		
	}
}
