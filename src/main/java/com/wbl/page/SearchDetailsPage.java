package com.wbl.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.wbl.helper.ByClass;

public class SearchDetailsPage {

	static Logger logger = LogManager.getLogger(SearchDetailsPage.class);

	WebDriver driver;

	public SearchDetailsPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getColor(String col) {

		String result = "";

		System.out.println("entered page" + col);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement element = driver.findElement((ByClass.getByObject("xpath-color", col, "')]")));
 
		String value = element.getAttribute("class");

		System.out.println("value : " + value);

		if (value.equalsIgnoreCase("variant")) {
			element.click();
			result = "color found";

		}

		else if (value.equalsIgnoreCase("variant disabled")) {
			element.click();
			result = "color disabled";

		}

	
		System.out.println("the color result is : " + result);
		return result;
	}

	public String getSize(String sz) throws InterruptedException {

		String value = "";

		WebDriverWait wait = new WebDriverWait(driver, 25);
		// to get the drop down for size
	/*	
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("css-dropDownSize")));
		
		*/
		
		
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("xpath-dropDownSize")));
		
		
		element.click();

		wait = new WebDriverWait(driver, 25);

		element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("css-chooseSize", sz, "']")));
		element.click();

		Thread.sleep(2000);

		wait = new WebDriverWait(driver, 25);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("css-addToCartBtn")));

		value = element.getAttribute("data-tl-id");

		System.out.println("the element details are for value " + value);

		if (value.equalsIgnoreCase("cta_oos_button")) {

			value = element.getText();
			System.out.println("size not availabale " + value);
		} else if (value.equalsIgnoreCase("ProductPrimaryCTA-cta_add_to_cart_button")) {
			// .//button[contains(@class,'btn-primary')]/span

			value = element.getText();
			System.out.println("size availabale " + value);

		}

		return value;

	}

	public String getQuantity(String qnty) throws InterruptedException {

		System.out.println("entered qnty method  : " + qnty);

 
		WebDriverWait wait = new WebDriverWait(driver, 25);
  
		List<WebElement> listElements = new ArrayList<WebElement>();
		 listElements= driver.findElements(By.cssSelector(".chooser-option-current"));
		 
		 listElements.get(1).click();
		 
		 
		 System.out.println("list size : " + listElements.size());
		Actions action = new Actions(driver);
	 
		
 
		 Thread.sleep(4000);
		 
		wait = new WebDriverWait(driver, 25);
 
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("xpath-qnty",qnty ,"')]")));
		
  
         Thread.sleep(500);
		
		action.moveToElement(element).build().perform();

		element.click();
       		
	 

 		Thread.sleep(2000);

	    action = new Actions(driver);

		wait = new WebDriverWait(driver, 25);

	  element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ByClass.getByObject("css-addToCartBtn")));

		action.moveToElement(element).perform();

  
		System.out.println("element get text : " + element.getText());

		return element.getText();
	}

}
