package com.myStore.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myStore.pageObjects.BaseClass;
import com.myStore.pageObjects.Home;
import com.myStore.pageObjects.Womens;


public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void SelectTopFromHomePage() throws InterruptedException{
		System.out.println("HEllo First Test::: "+driver.getTitle());
		logger.info("Started Test 1 ....");
		Home ObjHome = new Home(driver);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Store"));
		logger.info("Home page Title assertion done ....");
		ObjHome.ClickOnWomenLink();
		logger.info("Clicked on Womens link ....");
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Women - My Store"));
		Womens ObjWomens = new Womens(driver);
		ObjWomens.Click_SubCategory_Tops();
		logger.info("Clicked on SubCategory Tops Links  ....");
		Assert.assertTrue("Verify Header Contains Tops", ObjWomens.getHeader().contains("TOPS"));
		logger.info("Assertion of Tops done in header ....");
	
	}
	
}
