package com.sunpharma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sunpharma.base.BasePage;
import com.sunpharma.base.ElementUtil;
import com.sunpharma.base.JavaScriptUtil;


public class RegistrationPage extends BasePage {

	//WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	// locators - By
	By emailId = By.id("ap_email");
	By continueButton = By.id("continue");
	By createAccountButton = By.id("createAccountSubmit");
	By name = By.id("ap_customer_name");
	By phone_number = By.id("ap_phone_number");
	By password = By.id("ap_password");
	By auth_button = By.id("auth-verify-button");
	By signUpLink = By.xpath("//span[contains(text(),'Hello.')]");
	

	public RegistrationPage(WebDriver driver) {
		driver1 = driver;
		elementUtil = new ElementUtil(driver1);
		jsUtil = new JavaScriptUtil(driver1);
	}

	public void clickSignUpLink() {
		elementUtil.waitForElementPresent(signUpLink);
		elementUtil.doClick(signUpLink);
	}
	
	public void startRegistration() throws InterruptedException {
		elementUtil.waitForElementPresent(createAccountButton);
		elementUtil.doClick(createAccountButton);
		elementUtil.waitForElementPresent(name);
		elementUtil.doSendKeys(name, "Joseph Babu");
		elementUtil.waitForElementPresent(phone_number);
		elementUtil.doSendKeys(phone_number, "7012927465");
		elementUtil.waitForElementPresent(password);
		elementUtil.doSendKeys(password, "password123");
		elementUtil.waitForElementPresent(continueButton);
		elementUtil.doClick(continueButton);
		if (driver1.findElements(By.xpath("//h4[contains(text(),'Mobile number already in use')]")).size() > 0)
		{
			System.out.println("Mobile number already in use");
		}
		else
		{
			Thread.sleep(15000);//for reading OTP
			elementUtil.waitForElementPresent(auth_button);
			elementUtil.doClick(auth_button);
		}
	}
	

}
