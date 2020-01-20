package com.myStore.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.myStore.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	String baseURL = readConfig.getApplicationURL();
	protected String email = readConfig.getUsername();
	protected String pwd = readConfig.getPassword();
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser){
		System.out.println("Inside Setup method of BASE CLASS.......");
		logger = Logger.getLogger("MyStore");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Browser passed from testng file ::::: "+browser);
		if (browser.equalsIgnoreCase("chrome")){
		//WebDriverManager.chromedriver().setup();  
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		System.out.println(readConfig.getChromePath());
		System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu"); 
		driver = new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		
		
		
		driver.manage().window().maximize();
		logger.info("Browser Maximised URL ........");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.get(baseURL);
		driver.get(readConfig.getApplicationURL());
		logger.info("Opening URL from Read Config ........");
		
	}
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
		if(driver!=null)
			driver=null;
}
	
	

}
