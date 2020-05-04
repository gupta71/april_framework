package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import util.Elementutil;

public class Homepage extends Base{
	WebDriver driver;
	Elementutil elementutil;
	
	By header=By.cssSelector("h1.private-page__title");
	By accoutname=By.cssSelector("a#account-menu");
	
	//for going to contact page we have to create locator for this
	By maincontactpage=By.xpath("//a[contains(text(),'Contacts')][1]");
    By childcontactpage=By.xpath("//div[@role='menu' and @aria-label='Contacts']/ul/li/a[1]");
	
	public Homepage(WebDriver driver) {
this.driver=driver;
elementutil =new Elementutil(driver);
}
//page actions
	public String getHomepagetitle() {
		return elementutil.dogettitle();
	}
	
	public String getHomepageHeader() {
		return elementutil.doGettext(header);
	}
public String getLoggedInuserAccountName() {
	return elementutil.doGettext(accoutname);
}

//so when we r login the page at that time we r landing to the home page so contact links are 
//coming on homepage
	
	 public void clickoncontacts() throws InterruptedException {
	elementutil.waitforelementpresent(maincontactpage); //Thread.sleep(5000);
	 elementutil.doclick(maincontactpage);
	 
	elementutil.waitforelementpresent(childcontactpage); //Thread.sleep(2000);
	  elementutil.doclick(childcontactpage); }
	  
	  public Contactspage gotocontactpage() throws InterruptedException {
	  clickoncontacts(); return new Contactspage(driver); }
	 
	
	
	
	
}