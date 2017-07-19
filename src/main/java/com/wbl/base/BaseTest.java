package com.wbl.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.wbl.helper.ByClass;
import com.wbl.helper.ConfigUtils;
import com.wbl.helper.Constants;

public class BaseTest implements Constants  {
	
	public static String browserName;
	public static String url; 
	Properties prop;
	protected WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite()  {
		
		System.out.println("entered");
		
		try {
 	    	prop = ConfigUtils.loadConfigProperties("config.properties");
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		
      browserName =  prop.getProperty("browser");
      url =   prop.getProperty("appUrl");
		
		System.out.println("entered");
 
     driver =   ConfigUtils.getDriver(browserName);
     
     System.out.println(url);
     
 //    driver.get(url);
     
		ByClass.loadProperties();
 
     
   /*  try {
	    	prop = ConfigUtils.loadFile("locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	

	@AfterSuite
	public void afterSuite() {

//	 	driver.close();

	}


}
