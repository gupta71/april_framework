package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;
import io.qameta.allure.Step;
import util.Elementutil;
import util.Javascriptutil;

public class Contactspage extends Base {
	WebDriver driver;
	Elementutil elementutil;
	Javascriptutil jsutil;
	
	
	By createcontactbutton=By.xpath("//button[@type='button']//span[text()='Create contact'][position()=1]");
By createformbuttoon=By.xpath("//button[@data-selenium-test='base-dialog-confirm-btn']/span");
	
By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
	
	public Contactspage(WebDriver driver) {
	this.driver=driver;
	elementutil =new Elementutil(driver);
	jsutil=new Javascriptutil(driver);
	}
	
	public String getcontactpagetitle() {
		return elementutil.dogettitle();
	}
	
	@Step("create new contact with{0},{1},{2},{3}")
	public void createnewcontacts(String mail,String fn,String ln,String jt) throws InterruptedException {
		//elementutil.waitforelementpresent(createcontactbutton);
		Thread.sleep(5000);
		elementutil.doclick(createcontactbutton);
		Thread.sleep(5000);
		
		//elementutil.waitforelementpresent(email);
		elementutil.dosendkeys(email, mail);
		elementutil.dosendkeys(firstname, fn);
		elementutil.dosendkeys(lastname, ln);
		elementutil.dosendkeys(jobtitle, jt);
		//Thread.sleep(5000);
		elementutil.doclick(createformbuttoon);
		//jsutil.clickelementbyjs(elementutil.getelement(createformbuttoon));
	}
	
	
	
	
	
	
}
