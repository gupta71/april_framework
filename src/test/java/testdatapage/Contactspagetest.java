package testdatapage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pagelayer.Contactspage;
import pagelayer.Homepage;
import pagelayer.Loginpage;
import util.Constant;
import util.Crediantls;
import util.Excelutil;

public class Contactspagetest {
	Base basepage;
	Properties prop;
	WebDriver driver;
	Loginpage login;
Homepage hp;
Crediantls usercred;
Contactspage contactspage;
	
	
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
	contactspage=hp.gotocontactpage();

}
	
	@Test(priority=1)
	public void verifycontactspagetitle() {
	String title=	contactspage.getcontactpagetitle();
	System.out.println("contactspagetitle is:"+title);
	}
	
	@DataProvider
	public Object[][] getcontacttestdata() {
	Object[][]data=	Excelutil.gettestdata(Constant.contacts_sheet_name);
		return data;
	}
	
	@Test(priority=2, dataProvider="getcontacttestdata")
	public void createcontacttest(String email,String firstname,String lastname,String jobtitle) throws InterruptedException {
		contactspage.createnewcontacts(email,firstname,lastname,jobtitle);
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}	
}