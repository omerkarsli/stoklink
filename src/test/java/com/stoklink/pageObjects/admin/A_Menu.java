package com.stoklink.pageObjects.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class A_Menu {

    WebDriver driver;

    public A_Menu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[@title='Teklif İşlemleri']")
    public WebElement teklifIslemleri;

    @FindBy(xpath="//a[@title='Sipariş İşlemleri']")
    public WebElement siparisIslemleri;

    @FindBy(xpath="//a[@title='Ürün Onay']")
    public WebElement urunOnay;

    @FindBy(xpath="//a[@title='Ürünler']")
    public WebElement urunler;

    @FindBy(xpath="//a[@title='Kullanıcı İşlemleri']")
    public WebElement kullaniciIslemleri;

}
