package testdatapage;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pagelayer.Contactspage;
import pagelayer.Homepage;
import pagelayer.Loginpage;
import util.Constant;
import util.Crediantls;
@Epic("Epic-102:create Home page feature")
@Feature("us-502:create test for Home page on hubspot")
public class Homepagetest {
	Base basepage;
	Properties prop;
	WebDriver driver;
	Loginpage login;                     
	Homepage hp;
Crediantls usercred;

	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		basepage=new Base();
		prop=basepage.initproperties();
	String browsername=	prop.getProperty("browser");
	driver=basepage.initdriver(browsername);
	driver.get(prop.getProperty("url"));
	login=new Loginpage(driver);
	Thread.sleep(5000);
	usercred=new Crediantls(prop.getProperty("username"), prop.getProperty("password"));
	 hp=login.logindo(usercred);
	Thread.sleep(5000);

}
	
	@Test(priority=1)
	@Description("verify Home page title test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyhomepagetitleTest() {
	String title=	hp.getHomepagetitle();
	System.out.println("homepage title is:"+title);
	Assert.assertEquals(title, Constant.Homepagetitle);
	}
	
	@Test(priority=2)
	@Description("verify Home page header test")
	@Severity(SeverityLevel.CRITICAL)
		public void verifyhomepageheadertest() {
		String header=	hp.getHomepageHeader();
		System.out.println("home page eader is:"+header);
		Assert.assertEquals(header, Constant.Homepageheader);
		}
		
	@Test(priority=3)
	@Description("verify Home page account test test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyloggedinusertest() {
		String accountname=hp.getLoggedInuserAccountName();
		System.out.println("logged in accountname:"+accountname);
		Assert.assertEquals(accountname,"");
	}
	
@AfterTest
	public void teardown(){
		driver.quit();
	}	
		
		
		
		
		
		
	}
