package com.stoklink.pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A_TeklifIslemleri extends A_Menu{

    public By tableTalep = By.xpath("//table[@role='grid']");
    public By talepSec = By.xpath("//button[@mattooltip='Talep Seç']");
    public By teklifGonder = By.xpath("//button[@mattooltip='Teklif Gönder']");

    public By tableTalepItems = By.xpath("//table[@role='grid']//following::table");
    public By talepItemSec = By.xpath("//button[@mattooltip='Talep Satırı Seç']");
    public By talepItemHistory = By.xpath("//button[@mattooltip='Talep Satırı Geçmişi']");

    public A_TeklifIslemleri(WebDriver driver){
        super(driver);
    }

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



}
