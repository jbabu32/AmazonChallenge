package com.sunpharma.testcases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.sunpharma.base.BasePage;
import com.sunpharma.pages.HomePage;
import com.sunpharma.pages.LoginPage;
import com.sunpharma.pages.RegistrationPage;

public class AmazonSunPharmaTests extends BasePage {

	BasePage basePage;
	Properties prop;
	RegistrationPage regPage;
	LoginPage loginPage;
	HomePage homePage;
	

	@Test(priority = 1, description = "verify Registration Test....")
	public void RegistrationTest() throws InterruptedException {
		
		regPage = new RegistrationPage(driver1);
		regPage.clickSignUpLink();
		regPage.startRegistration();
	}
	
	@Test(priority = 2, description = "verify Login Test....")
	public void LoginBuyItemsTest() throws InterruptedException {
		regPage = new RegistrationPage(driver1);
		loginPage = new LoginPage(driver1);
		regPage.clickSignUpLink();
		loginPage.doLogin();
		homePage = new HomePage(driver1);
		homePage.selectBooksandAudible();
		homePage.DoLogOut();
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver1.quit();
	}

}
