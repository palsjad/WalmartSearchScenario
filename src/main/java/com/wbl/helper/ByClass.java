package com.wbl.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ByClass {
	
 

	 	static  Logger logger = LogManager.getLogger(ByClass.class);
	 	
	 

	 	static Properties prop;
	 
	 public static void loadProperties() {

			try {
 		 		prop = ConfigUtils.loadFile("locators\\locators.properties");
 				
 		//		prop = ConfigUtils.loadFile("C:\\QA\\EclipseWorkspace\\WalmartSearchScenario\\resources\\locators\\locators.properties");
			   
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		}
 
		public static By getByObject(String key) {

			By by = null;

			String value = prop.getProperty(key); // replace prop.getProperty(key) by value below

			 System.out.println("key : "+ key + "   value : " + value);
	
			
			if (key.startsWith("css")) {

				System.out.println(By.cssSelector(value));
				return By.cssSelector(value);

			} else if (key.startsWith("xpath")) {
				
               System.out.println("2222222222  : " + By.xpath(value) );
				return (By.xpath(value));

			} else if (key.startsWith("link")) {
				return By.linkText(value);

			} else if (key.startsWith("id")) {
				return By.id(value);

			} else if (key.startsWith("partialLink")) {
				return By.partialLinkText(value);

			} else if (key.startsWith("tag")) {
				return By.tagName(value);

			} else if (key.startsWith("class")) {
				return By.className(value);

			} else if (key.startsWith("name")) {
				return By.name(value);
			} else
				return by;

		}

		public static By getByObject(String key, String input, String locator2) {

			System.out.println("inside by class : " + key + " " + input + "  " + locator2);
			
			By by = null;

			String value = prop.getProperty(key); // replace prop.getProperty(key) by value below

			value = value + input + locator2;

 			System.out.println("the key is : " + value);
			
	//		logger.info("the key created in the overridden ByClass method is :" + value);


			if (key.startsWith("css")) {
				System.out.println( By.cssSelector(value));


				return By.cssSelector(value);

			} else if (key.startsWith("xpath")) {
				System.out.println(By.xpath(value));

				return (By.xpath(value));

			} else if (key.startsWith("link")) {
				return By.linkText(value);

			} else if (key.startsWith("id")) {
				return By.id(value);

			} else if (key.startsWith("partialLink")) {
				return By.partialLinkText(value);

			} else if (key.startsWith("tag")) {
				return By.tagName(value);

			} else if (key.startsWith("class")) {
				return By.className(value);

			} else if (key.startsWith("name")) {
				return By.name(value);
			} else
				return by;

		}

}
