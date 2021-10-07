package com.stoklink.pageObjects.admin;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class A_Menu {

    WebDriver driver;
    NgWebDriver ng;

    public A_Menu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        ng = new NgWebDriver((JavascriptExecutor)driver);
    }

    @FindBy(css="a[title='Teklif İşlemleri']")
    public WebElement teklifIslemleri;

    @FindBy(css="a[title='Sipariş İşlemleri']")
    public WebElement siparisIslemleri;

    @FindBy(css="a[title='Ürün Onay']")
    public WebElement urunOnay;

    @FindBy(css="a[title='Ürünler']")
    public WebElement urunler;

    @FindBy(css="a[title='Kullanıcı İşlemleri']")
    public WebElement kullaniciIslemleri;

    public void clickSiparisIslemleri(){
        siparisIslemleri.click();
        ng.waitForAngularRequestsToFinish();
    }

    public void clickTeklifIslemleri(){
        teklifIslemleri.click();
        ng.waitForAngularRequestsToFinish();
    }

    public void clickUrunOnay(){
        urunOnay.click();
        ng.waitForAngularRequestsToFinish();
    }

    public void clickUrunler(){
        urunler.click();
        ng.waitForAngularRequestsToFinish();
    }

    public void clickKullaniciIslemleri(){
        kullaniciIslemleri.click();
        ng.waitForAngularRequestsToFinish();
    }



}
