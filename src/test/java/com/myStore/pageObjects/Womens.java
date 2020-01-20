package com.myStore.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Womens {

WebDriver driver;
	
@FindBy(xpath="//div[@class='subcategory-image']/a[@title='Tops']")
WebElement subCategoryTops;

@FindBy(xpath="//h1[@class='page-heading product-listing']")
WebElement header;


	public Womens(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Click_SubCategory_Tops(){
		subCategoryTops.click();
	}

	public String getHeader(){
		return header.getText();
	}
	
	
}
