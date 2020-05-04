package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascriptutil {
	WebDriver driver;
	
	public Javascriptutil( WebDriver driver) {
		this.driver=driver;
	}
	public void clickelementbyjs(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("argument[0].click();",element);
		
	}
	public void changecolor(String color,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("argument[0].style.backgroundcolor="+ color+" ' ", element);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flash(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
	String bgcolor=element.getCssValue("backgroundcolor");
	for(int i=0;i<10;i++) {
		changecolor("rgb(0,200,0)",element);	//1
		changecolor(bgcolor,element);//2
	}
	
	
	
	

	}}
