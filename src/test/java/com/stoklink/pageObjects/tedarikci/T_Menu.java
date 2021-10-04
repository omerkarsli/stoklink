package com.stoklink.pageObjects.tedarikci;

import com.stoklink.pageObjects.musteri.M_Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class T_Menu{

    WebDriver driver;

    public T_Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Teklif Arama / Verme']")
    public WebElement teklifAraVer;

    @FindBy(xpath = "//a[@title='Sipariş Onay']")
    public WebElement siparisOnay;

}

