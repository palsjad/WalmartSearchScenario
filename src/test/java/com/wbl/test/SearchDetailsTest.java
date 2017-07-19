package com.wbl.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.helper.ExcelHelper;
 import com.wbl.page.SearchDetailsPage;
 

 
 
 

public class SearchDetailsTest extends BaseTest {
	
	static Logger logger = LogManager.getLogger(SearchDetailsTest.class);

	
//	 WebDriver driver;
	 SearchDetailsPage sd ;
	 Object[][] data;	
	 
	public  String res = "";
	public  String res1 = "";
	 
	@BeforeClass
	public void before() {
		
		System.out.println("beforeclass");
		sd = new SearchDetailsPage(driver);
/*		
driver.get("https://www.walmart.com/ip/Ekidsbridal-Wedding-Pageant-Glitter-Sequin-Tulle-Flower-Girl-Dress-"
		+ "Toddler-Junior-Bridesmaid-Recital-Easter-Holiday-Communion-Birthday-Girls-Clothing/585061526?variantFieldId="
		+ "actual_color");
		*/
	//	System.out.println(driver.getTitle());

	}
	
	@DataProvider(name = "SearchDetails")
	public Object[][] allDropDownData() {

 
		data = ExcelHelper.getExcelData("test-data\\SearchDetails.xlsx", "Search");

		return data;

	}
	

	@DataProvider(name = "Color")
	public Object[][] colorData() {

 
		data = ExcelHelper.getExcelData("test-data\\SearchDetails.xlsx", "Color");

		return data;

	}
	
	
	@DataProvider(name = "Size")
	public Object[][] sizeData() {

 
		data = ExcelHelper.getExcelData("test-data\\SearchDetails.xlsx", "Size");

		return data;

	}
	
	

	@DataProvider(name = "Quantity")
	public Object[][] qntyData() {

 
		data = ExcelHelper.getExcelData("test-data\\SearchDetails.xlsx", "Quantity");

		return data;

	}
	
	
//	@Test(dataProvider = "Color")	
	
	
	@Test(dataProvider = "SearchDetails")
	public void getColorTest(String url, String color, String size, String qnty, String expected1, String expected2) {
		
 		
 	 	driver.get(url);
		
		String res = sd.getColor(color);
		
		System.out.println("result : " + res);
		
		Assert.assertEquals(expected1, res);
		
		
	}
	
//	@Test(dataProvider = "Size")
	
	@Test(dataProvider = "SearchDetails")
	public void getSizeTest(String url, String color, String size, String qnty , String expected1,String expected2) throws InterruptedException {
		
 //		driver.get(url);
		
	//	String res1 = "";

//		String res = sd.getColor(color);
		
 /*		
		if(res.equalsIgnoreCase("color disabled")){
			 System.out.println("this color is disabled");
			 expected2 = "color disabled";
		 }
		 else {
		  res = sd.getSize(size);	
		 }
		 */
		
		System.out.println("inside size  res : " + res);
		
		
		if (! res.equalsIgnoreCase("color disabled")) {
		  res1 = sd.getSize(size);	
		}
		
		
		Assert.assertEquals(res1, expected2);
		
	}
	
//	@Test(dataProvider = "Quantity")
	
	@Test(dataProvider = "SearchDetails")
	public void getQuantityTest(String url, String color, String size, String qnty, String expected1, String expected2) throws InterruptedException {
		
 //		driver.get(url);
//		driver.manage().window().maximize();

//      String res = "";
	//   res = sd.getColor(color);
		
	//	if(res.equalsIgnoreCase("color disabled")){
 //    res = "color not available";
	
			
			if (! res.equalsIgnoreCase("color disabled")) {
		 
	//			  res = sd.getSize(size);	
		
		          res = sd.getQuantity(qnty);
			}
		
		System.out.println("res : " + res);
	}
	
	

}
