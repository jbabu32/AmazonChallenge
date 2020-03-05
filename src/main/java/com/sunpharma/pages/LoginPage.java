package com.sunpharma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sunpharma.base.BasePage;
import com.sunpharma.base.ElementUtil;
import com.sunpharma.base.JavaScriptUtil;



public class LoginPage extends BasePage {
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	By emailId = By.id("ap_email");
	By continueButton = By.id("continue");
	By password = By.id("ap_password");
	By loginButton = By.id("signInSubmit");
	By otpButton = By.id("a-autoid-0");
	By otpContinueButton = By.id("a-autoid-0");

	public LoginPage(WebDriver driver) {
		driver1 = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public void doLogin() throws InterruptedException {
		elementUtil.waitForElementPresent(emailId);
		elementUtil.doSendKeys(emailId, "7012927465");
		elementUtil.waitForElementPresent(continueButton);
		elementUtil.doClick(continueButton);
		elementUtil.waitForElementPresent(password);
		elementUtil.doSendKeys(password, "password123");
		elementUtil.waitForElementPresent(loginButton);
		elementUtil.doClick(loginButton);
		if (!driver1.findElement(otpButton).isDisplayed())
		{
			System.out.println("Otp Button not visible");
		}
		else
		{
			elementUtil.waitForElementPresent(otpButton);
			elementUtil.doClick(otpButton);
			Thread.sleep(15000);//for reading OTP
			elementUtil.waitForElementPresent(otpButton);
			elementUtil.doClick(otpButton);
			Thread.sleep(15000);//for reading OTP
			elementUtil.waitForElementPresent(otpContinueButton);
			elementUtil.doClick(otpContinueButton);
		}
		
		}
	}

