package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigUtils {
	
	
	public static Properties loadFile(String fileName) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream(Constants.PATH + fileName));
			
		return prop;
		
		
	}
	
	
public static Properties loadConfigProperties(String fileName) throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream(Constants.PATH + fileName));
		
	 
		return prop;
		
		
	}
	
	
	public static WebDriver getDriver(String browserNm) {
		
		System.out.println("broser name " + browserNm);
		
		WebDriver driver = null;
		
		if (browserNm.equals("chrome")) {
			
			 System.setProperty("webdriver.chrome.driver", Constants.PATH + "chromedriver.exe");
			 driver = new ChromeDriver();
 			
		}
		
		return driver;
		
		}
		
		
	}
 
