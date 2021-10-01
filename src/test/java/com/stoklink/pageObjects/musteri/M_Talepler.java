package com.stoklink.pageObjects.musteri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class M_Talepler extends M_Menu {

    public M_Talepler(WebDriver driver){
        super(driver);
    }


    @FindBy(xpath="//mat-select[@formcontrolname='durum']")
    public WebElement durum;


    @FindBy(xpath="//input[@formcontrolname='baslangicTarihi']")
    public WebElement baslangicTarihi;

    @FindBy(xpath="//input[@formcontrolname='bitisTarihi']")
    public WebElement bitisTarihi;

    @FindBy(id="input-searchText")
    public WebElement talepIsim;

    @FindBy(xpath="//span[contains(text(), 'Filtrele')]")
    public WebElement filtrele;

    By table = By.xpath("//table[@role='grid']");
    By talepGoruntule = By.xpath("//button[@mattooltip='Talep Görüntüle']");
    By talepGuncelle = By.xpath("//button[@mattooltip='Talep Güncelle']");
    By siparisVer = By.xpath("//button[@mattooltip='Sipariş Ver']");

    public WebElement getTalep(String talepNo) {
        return driver.findElement(table).findElement(By.xpath("" +
                "," + talepNo + ")]"));
    }



}
