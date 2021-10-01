package com.stoklink.pageObjects.musteri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class M_Menu {

    WebDriver driver;

    public M_Menu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[@title='Talepler']")
    public WebElement talepler;

    @FindBy(xpath="//a[@title='Siparişler']")
    public WebElement siparisler;

    @FindBy(xpath="//a[@title='Talep Oluştur']")
    public WebElement talepOlustur;

    @FindBy(xpath="//a[@title='Toplu Talep Oluştur']")
    public WebElement topluTalepOlustur;

    @FindBy(xpath="//nb-action[@nbtooltip='Güvenli Çıkış']//button")
    public WebElement cikisyap;

    @FindBy(css="a[title='Müşteri']")
    public WebElement musteriMenu;

    public boolean isTedarikci(){
        return driver.findElement(By.cssSelector("a[title='Müşteri']")).isDisplayed();
    }
}
