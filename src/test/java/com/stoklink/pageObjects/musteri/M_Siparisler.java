package com.stoklink.pageObjects.musteri;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M_Siparisler extends M_Menu{

    public M_Siparisler(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "table[mat-table][role='grid']")
    public WebElement siparisTablo;

    @FindBy(xpath = "//tbody//following::tbody[1]")
    public WebElement siparisListe;

    @FindBy(xpath = "//button[.='SİPARİŞ VER']")
    public WebElement siparisVerBtn;

    @FindBy(xpath = "//tbody//following::tbody[2]")
    public WebElement sepetTablo;




    public void muadilOnayla(WebElement row){

        WebElement muadilToggle = row.findElement(By.cssSelector("mat-slide-toggle"));
        String classAttr =  muadilToggle.getAttribute("class");

        if(!(classAttr.contains("mat-disabled"))){
          muadilToggle.click();
        }
    }

    public void sepeteEkle(WebElement row){
        WebElement sepetBtn = row.findElement(By.cssSelector("button[mattooltip='Sepete Ekle']"));
        sepetBtn.click();
        new NgWebDriver((JavascriptExecutor)driver).waitForAngularRequestsToFinish();

    }

    public void clickTalepSec(WebElement row){
        WebElement talepSecBtn = row.findElement(By.xpath(".//button[contains(.,'mouse')]"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(talepSecBtn))
                .click();
        new NgWebDriver((JavascriptExecutor)driver).waitForAngularRequestsToFinish();
    }

    public void siparisVer(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        NgWebDriver ng = new NgWebDriver((JavascriptExecutor)driver);

        wait
            .until(ExpectedConditions.elementToBeClickable(siparisVerBtn))
            .click();

        ng.waitForAngularRequestsToFinish();

        wait
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='SİPARİŞİ TAMAMLA']")))
            .click();
        ng.waitForAngularRequestsToFinish();

    }
}
