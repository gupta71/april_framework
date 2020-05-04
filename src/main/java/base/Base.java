package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	//public WebDriver driver;
	public Properties prop;
	//public static boolean highlightelement;
	//public Optionsmanager optionsmanager;
	
	//we r creating threadlocal object for multi purpose work like parallel cross browser
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	public WebDriver initdriver(String browsername) {
	//highlightelement=	prop.getProperty("highlight").equals("yes") ? true : false;
		//optionsmanager=new Optionsmanager(prop);
		if(browsername.equals("chrome")) {
		//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
			/*
			 * if(prop.getProperty("headless").equals("yes")) { ChromeOptions options=new
			 * ChromeOptions(); options.addArguments("window-size=1400,800");
			 * options.addArguments("headless"); WebDriver driver=new ChromeDriver(options);
			 * } else {
			 */
		//driver=new ChromeDriver(optionsmanager.getchromeoptions());
			tldriver.set(new ChromeDriver());
					}
		
		else if(browsername.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else {
			System.out.println("browsername"+browsername+" is not found ,please pass the correct browser");
		}
		getDriver().manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().manage().window().fullscreen();
	return getDriver();
	}
	
	public Properties initproperties() {
		Properties prop=new Properties();
String path=null;
String env=null;
try {
env=System.getProperty("env");

if(env.equals("qa")) {
	path="C:\\Users\\cute puja\\eclipse-workspace\\aprilpomser\\"
			+ "src\\main\\java\\config\\qa.config.properties";
}
else if(env.equals("stage")) {
	path="C:\\Users\\cute puja\\eclipse-workspace\\aprilpomser\\"
			+ "src\\main\\java\\config\\stage.config.properties";
}
}catch(Exception e) {
	path="C:\\Users\\cute puja\\eclipse-workspace\\aprilpomser\\"
			+ "src\\main\\java\\config\\config.properties";
}

		try {
			FileInputStream ip=new FileInputStream(path);
			
				prop.load(ip);
			} catch (FileNotFoundException e) {
				
				System.out.println("some issue with the config file please change the congfig file prop");
			}
		 catch(IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	
	//take screenshot method
	
	public String getScreenshot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//Screenshot"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("screenshot capture failed...");
		}
		return path;
	}

	
	}
	

