package com.stoklink.pageObjects.musteri;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    @FindBy(css="a[title='Talep Oluştur']")
    public WebElement talepOlustur;

    @FindBy(xpath="//a[@title='Toplu Talep Oluştur']")
    public WebElement topluTalepOlustur;

    @FindBy(xpath="//nb-action[@nbtooltip='Güvenli Çıkış']//button")
    public WebElement cikisyap;

    @FindBy(css="a[title='Müşteri']")
    public WebElement musteriMenu;

    public boolean isTedarikci(){
       try{
           return driver.findElement(By.cssSelector("a[title='Müşteri']")).isDisplayed();
       }catch (NoSuchElementException e){
           return false;
       }
    }

    public void clickMusteriMenu() throws InterruptedException {
        Thread.sleep(2000);
        new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
        musteriMenu.click();
    }

    public void clickTalepOlustur(FluentWait<WebDriver> wait) throws InterruptedException {
            try {
                talepOlustur.click();
            } catch (Exception e) {
                if (isTedarikci() && !(talepOlustur.isDisplayed())) {
                    clickMusteriMenu();
                }
                wait.until(ExpectedConditions.elementToBeClickable(talepOlustur)).click();


            }
    }
}
