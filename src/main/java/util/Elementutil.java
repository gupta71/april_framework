package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Elementutil extends Base {
	WebDriver driver;
	WebDriverWait wait;
	//Javascriptutil jsutil;
	//this method is used to create the webelement on the basiss of by locator
	//return element
	
	public Elementutil(WebDriver driver) {
	this.driver=driver;
	wait=new WebDriverWait(driver,Constant.default_time_out);
//	jsutil=new Javascriptutil(driver);
	}
	//0method
	public String  dogettitle() {
		try {
		return driver.getTitle();
	}
		catch(Exception e) {
			System.out.println("some exception got occured while entering the title ");
		}
		return null;
		}
			
		
	
	//1stmethod
	public WebElement getelement(By locator) {
		WebElement element=null;
		try {
		 element=driver.findElement(locator);
		 //if(highlightelement) {
			// jsutil.flash(element);
		 
		}
		catch(Exception e) {
			System.out.println("some exception got occured while creating hte webelement ");
		}
	return element;
	}
	
	//2nd method
	public void doclick(By locator) {
		try {
		getelement(locator).click();
		}
		catch(Exception e) {
			System.out.println("some exception got occured while clicking on hte webelement ");
		}
	}
	
	//3rdd method
	public void dosendkeys(By locator,String value) {
		try {
		getelement(locator).clear();
		getelement(locator).sendKeys(value);
}
		catch(Exception e) {
			System.out.println("some exception got occured while entering the value in field  ");
		}
}
	//4th method
	public boolean doisdisplayed(By locator) {
		try {
		return getelement(locator).isDisplayed();
		}
		catch(Exception e) {
			System.out.println("some exception got occured while displaying hte webelement ");
		}
		return false;
	}
	//5th method
	public String doGettext(By locator) {
		try {
		return getelement(locator).getText();
	}
		catch(Exception e) {
			System.out.println("some exception got occured while getting the text in hte webelement ");
		}
		return null;
	}
	//6th method
	public boolean waitforelementpresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	//7th method
	public boolean waitforelementvisible(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		return true;
	}
	//8th method
	public boolean waitfortitlepresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
		
	}
	
		
	}
		
	
