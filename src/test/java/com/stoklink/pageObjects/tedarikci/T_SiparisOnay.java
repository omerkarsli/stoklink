package com.stoklink.pageObjects.tedarikci;

import org.openqa.selenium.By;
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

    @FindBy(xpath="//span[contains(., 'Filtrele')]")
    public WebElement filtrele;


    public void siparisOnayla(WebElement row){
        WebElement onayBtn = row.findElement(By.cssSelector("button[mattooltip='Siparişi Onayla']"));
        String miktar = row.findElement(By.xpath(".//td[contains(@class, 'mat-column-teklifMiktar')]")).getText();
        miktar = miktar.substring(0,miktar.indexOf(" "));
        WebElement onayMiktar = row.findElement(By.name("siparisMiktar"));
        onayMiktar.sendKeys(miktar);
        onayBtn.click();
        ng.waitForAngularRequestsToFinish();
    }

}
