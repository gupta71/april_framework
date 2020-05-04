package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import util.Constant;
import util.Crediantls;
import util.Elementutil;
import util.Javascriptutil;

public class Loginpage extends Base {
	WebDriver driver;
	Elementutil elementutil;
	//Javascriptutil jsutil;
	
	//locator by
	By emailid=By.id("username");
	By password=By.id("password");
	By login=By.xpath("//button[@type='submit']/i18n-string");
	By signuplink=By.linkText("Sign up");
	By loginerrrortext=By.xpath("//div[@class='private-alert__inner']/h5");
	
	
	//creating the constructou
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		elementutil =new Elementutil(driver);
		//jsutil=new Javascriptutil(driver); 
	}
	
	//page actions
	public String getpagetitle() {
		elementutil.waitfortitlepresent(Constant.loginpagetitle);
		return elementutil.dogettitle();
		
	}
	public boolean checksignuplink() {
		elementutil.waitforelementpresent(signuplink);
		return elementutil.doisdisplayed(signuplink);
	}
	public Homepage logindo(Crediantls usercred) throws InterruptedException {
		//elementutil.waitforelementvisible(emailid);
	Thread.sleep(2000);
		elementutil.dosendkeys(emailid,usercred.getappusername());
		elementutil.dosendkeys(password, usercred.getapppassword());
		Thread.sleep(10000);
		elementutil.doclick(login);
		Thread.sleep(10000);
		return new Homepage(driver);
	}
	public boolean checkerrormsg() {
		return elementutil.doisdisplayed(loginerrrortext);
	}

}
