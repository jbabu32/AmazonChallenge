package com.sunpharma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sunpharma.base.BasePage;
import com.sunpharma.base.ElementUtil;
import com.sunpharma.base.JavaScriptUtil;



public class HomePage extends BasePage {
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	By side_bar_button = By.xpath("//i[contains(@class, 'hm-icon')]");
	By textbooks_link = By.xpath("//a//div[normalize-space()='Textbooks']");
	By textbook_type_link = By.xpath("(//a//span[text()='Computer Science'])[3]");
	By add_to_cart_button = By.id("add-to-cart-button");
	By cart_button = By.xpath("(//a[normalize-space()='Cart'])[1]");
	By remove_from_cart = By.xpath("(//input[@value='Delete'])[1]");
	By sign_out_button = By.xpath("//span[text()='Sign Out']");
	
	public HomePage(WebDriver driver) {
		driver1 = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public void selectBooksandAudible() {
		elementUtil.waitForElementPresent(side_bar_button);
		elementUtil.doClick(side_bar_button);
		WebElement elementName = driver1.findElement(By.xpath("//a//div[normalize-space()='Books & Audible']"));
		jsUtil.scrollIntoView(elementName);
		elementUtil.waitForElementPresent(By.xpath("//a//div[normalize-space()='Books & Audible']"));
		elementUtil.doClick(By.xpath("//a//div[normalize-space()='Books & Audible']"));
		elementUtil.waitForElementPresent(textbooks_link);
		elementUtil.doClick(textbooks_link);
		elementUtil.waitForElementPresent(textbook_type_link);
		elementUtil.doClick(textbook_type_link);
		elementUtil.waitForElementPresent(By.xpath("(//h2)[1]"));
		elementUtil.doClick(By.xpath("(//h2)[1]"));
		elementUtil.waitForElementPresent(By.xpath("(//h1//span)[1]"));
		
		String Bookname = elementUtil.doGetText(By.xpath("(//h1//span)[1]"));
		System.out.println("Bookname = " + Bookname);
		
		elementUtil.waitForElementPresent(add_to_cart_button);
		elementUtil.doClick(add_to_cart_button);
		
		String Bookprice = elementUtil.doGetText(By.xpath("(//span[contains(@style,'decoration')])[1]"));
		System.out.println("Bookprice = " + Bookprice);
		
		elementUtil.waitForElementPresent(cart_button);
		elementUtil.doClick(cart_button);
		
		elementUtil.waitForElementPresent(remove_from_cart);
		elementUtil.doClick(remove_from_cart);
		
	}
		
	public void DoLogOut() throws InterruptedException {
		
		Thread.sleep(10000);
		elementUtil.waitForElementPresent(By.xpath("//span[text()='Hello, Joseph']"));
		WebElement element = driver1.findElement(By.xpath("//span[text()='Hello, Joseph']"));
		Actions action = new Actions(driver1);
		action.moveToElement(element).perform();
		
		elementUtil.waitForElementPresent(sign_out_button);
		elementUtil.doClick(sign_out_button);
		
	}


}
