package com.stoklink.Features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stoklink.pageObjects.Login;
import com.stoklink.pageObjects.admin.A_Menu;
import com.stoklink.pageObjects.admin.A_TeklifIslemleri;
import com.stoklink.pageObjects.musteri.M_Menu;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.utils.ReadConfig;

public class Base {
	public static WebDriver driver;
	public A_Menu aMenu;
	public A_TeklifIslemleri aTeklifIslemleri;
	public M_Menu mMenu;
	public M_Talepler mTalepler;
	public M_TalepOlustur mTalepOlustur;
	public Login login;
	public ReadConfig rc = new ReadConfig();
	public WebDriverWait wait;

}
