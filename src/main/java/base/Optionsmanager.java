package base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
public class Optionsmanager {
public Properties prop;
public ChromeOptions co;
public FirefoxOptions fo;
	
	public Optionsmanager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getchromeoptions() {
		co=new ChromeOptions();
		co.addArguments("--incognito");
		
		if(prop.getProperty("headless").equals("yes"))co.addArguments("--headless");
	return co;	
	}
	public FirefoxOptions getfirefoxoptions() {
		if(prop.getProperty("headless").equals("yes"))fo.addArguments("--headless");
		return fo;	
		
	}

}
