package com.stoklink.pageObjects.tedarikci;

import com.stoklink.pageObjects.musteri.M_Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T_Menu{

    WebDriver driver;

    public T_Menu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='Teklif Arama / Verme']")
    public WebElement teklifAraVer;

    @FindBy(css = "a[title='Tedarikçi']")
    public WebElement tedarikciBtn;

    @FindBy(css = "a[title='Sipariş Onay']")
    public WebElement siparisOnay;

    public void clickTedarikciBtn(FluentWait<WebDriver> wait) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(tedarikciBtn));
        tedarikciBtn.click();
    }

    public void clickTeklifAraVer(FluentWait<WebDriver> wait) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(tedarikciBtn));
        teklifAraVer.click();
    }


}

