package com.stoklink.pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class A_TeklifIslemleri {
    @FindBy(xpath="//span[contains(text(), 'Teklif Gönderilmeyi Bekleyenler')]")
    public WebElement durum;

    @FindBy(xpath="//input[@formcontrolname='baslangicTarihi']")
    public WebElement baslangicTarihi;

    @FindBy(xpath="//input[@formcontrolname='bitisTarihi']")
    public WebElement bitisTarihi;

    @FindBy(id="input-searchText")
    public WebElement talepIsim;

    @FindBy(xpath="//span[contains(text(), 'Filtrele')]")
    public WebElement filtrele;

    By tableTalep = By.xpath("//table[1][@role='grid']");
    By talepSec = By.xpath("//button[@mattooltip='Talep Seç']");
    By teklifGonder = By.xpath("//button[@mattooltip='Teklif Gönder']");

    By tableTalepItems = By.xpath("//table[2][@role='grid']");
    By talepItemSec = By.xpath("//button[@mattooltip='Talep Satırı Seç']");
    By talepItemHistory = By.xpath("//button[@mattooltip='Talep Satırı Geçmişi']");

}
