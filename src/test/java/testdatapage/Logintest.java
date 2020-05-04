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
import pagelayer.Homepage;
import pagelayer.Loginpage;
import util.Constant;
import util.Crediantls;

@Epic("Epic-101:create login page feature")
@Feature("us-501:create test for login page on hubspot")

public class Logintest {
	Base basepage;  
	Properties prop;
	WebDriver driver;
	Loginpage login;
	Homepage hp;
	Crediantls usercred;
	
	
	@BeforeTest()
	public void setup() {
		basepage=new Base();
		prop=basepage.initproperties();
	String browsername=	prop.getProperty("browser");
	driver=basepage.initdriver(browsername);
	driver.get(prop.getProperty("url"));
	login=new Loginpage(driver);
	usercred=new Crediantls(prop.getProperty("username"), prop.getProperty("password"));
	
	
	}
	
	@Test(priority=1)
	@Description("verify login page title test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyloginpagetitletest() {
		String title=login.getpagetitle();
		System.out.println("login page title is:"+title);
		//Assert.assertEquals(title, Constant.loginpagetitle);
		
	}
	
	@Test(priority=2, groups="sanity")
	@Description("verify signup link test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifysignuplinktest() {
	Assert.assertTrue(login.checksignuplink());
	}
	
	@Test(priority=3)
	@Description("verify login page title test")
	@Severity(SeverityLevel.BLOCKER )
	public void logintest() throws InterruptedException {
	hp=login.logindo(usercred);
	String accountname=hp.getLoggedInuserAccountName();
	//Thread.sleep(40000);
	//Assert.assertEquals(accountname, " null ");
	}
	
	/*@DataProvider
	public Object[][] getlogininvaliddata() {
		Object data[][]= {
				                      {"test111@gmail.com","test123"},
				                      {"tesst2@gmail.com","test123"},
		                             {"test12345@gmail.com","test4"},
		                             {"test",""}
		                             };
		return data;
		}
	//here we  are enabled the test cases bcz unnecessary this data going to excute 3to 4 times.
	@Test(priority=4,dataProvider="getlogininvaliddata",enabled=false)
	public void logininvalidtestcases(String username,String pwd) {
		usercred.setappusername(username);
		usercred.setapppassword(pwd);
		login.logindo(usercred);
		Assert.assertTrue(login.checkerrormsg());*/

	

		
	
	
	
	
	@AfterTest
	public void teardown() {
	driver.quit();
	
		
	

}
}