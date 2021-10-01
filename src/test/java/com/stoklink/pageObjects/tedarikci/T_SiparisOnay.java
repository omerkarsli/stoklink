package com.stoklink.pageObjects.tedarikci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class T_SiparisOnay extends T_Menu{

    public T_SiparisOnay(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//mat-select[@formcontrolname='durum']")
    @CacheLookup
    public WebElement durum;

    @FindBy(xpath="//input[@formcontrolname='baslangicTarihi']")
    @CacheLookup
    public WebElement baslangicTarihi;

    @FindBy(xpath="//input[@formcontrolname='bitisTarihi']")
    @CacheLookup
    public WebElement bitisTarihi;

    @FindBy(xpath="//span[contains(text(), 'Filtrele')]")
    @CacheLookup
    public WebElement filtrele;

    @FindBy(xpath="//button[contains(text(), 'SİPARİŞLERİ ONAYLA')]")
    @CacheLookup
    public WebElement siparisOnayla;

    @FindBy(xpath="//button[contains(text(), 'SİPARİŞLERİ REDDET')]")
    @CacheLookup
    public WebElement siparisReddet;
}
