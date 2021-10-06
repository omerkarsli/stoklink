package com.stoklink.pageObjects.tedarikci;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class T_SiparisOnay extends T_Menu{

    public T_SiparisOnay(WebDriver driver){
        super(driver);
    }

    @FindBy(css="mat-select[formcontrolname='durum']")
    public WebElement durum;

    @FindBy(css="input[formcontrolname='baslangicTarihi']")
    public WebElement baslangicTarihi;

    @FindBy(css="input[formcontrolname='bitisTarihi']")
    public WebElement bitisTarihi;

    @FindBy(xpath="//span[contains(text(), 'Filtrele')]")
    public WebElement filtrele;

    @FindBy(xpath="//button[contains(text(), 'SİPARİŞLERİ ONAYLA')]")
    public WebElement siparisOnayla;

    @FindBy(xpath="//button[contains(text(), 'SİPARİŞLERİ REDDET')]")

    public WebElement siparisReddet;

}
