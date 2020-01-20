package com.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement lnkWomen;
	
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnWomenLink(){
		//wait.until(ExpectedConditions.elementToBeClickable(linkWomen));
		lnkWomen.click();
		//return new Womens();
	}
	

}
