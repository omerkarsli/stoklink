package com.stoklink.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver ldriver;

	public Login(WebDriver rdriver) {
		ldriver = rdriver;
//In Page Factory, tester use @FindBy annotation.
// The initElements method is used to initialize web elements.
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(name = "username")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(xpath = "/html/body/ngx-app/ngx-pages/ngx-one-column-layout/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-auth-component/div/div/nb-card/nb-card-body/nb-auth-block/ngx-login/form/div/div/button")
	WebElement btnLogin;

	public void setTxtUserName(String uname) {
		txtUserName.sendKeys(uname);
	}

	public void setTxtPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin(){
		btnLogin.click();
	}

}
