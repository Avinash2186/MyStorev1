package com.myStore.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submitLogin;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement customerName;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSignInLink(){
		signIn.click();
	}
	
	public void EnterEmail(String inputEmail){
		email.sendKeys(inputEmail);
	}
	
	public void EnterPassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void submit(){
		submitLogin.click();
	}
	
	public String getCustomerName(){
		return customerName.getText();
	}
	
	
	
	
	
	
	
	
}
