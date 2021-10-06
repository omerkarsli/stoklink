package com.stoklink.testCases;

import com.stoklink.pageObjects.admin.A_TeklifIslemleri;
import com.stoklink.utils.baseUtils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class AdminTeklifOnayla extends Base {

    @Test
    public void teklifOnayla(ITestContext context){
        adminLogin();
        a = new A_TeklifIslemleri(driver);
        String talepNo = context.getAttribute("talepNo").toString();
        WebElement talepSatir = driver
                .findElement(a.tableTalep)
                .findElement(By.xpath(
                        ".//td[contains(text(),'"+ talepNo +"')]//parent::tr"));

        WebElement talepSec = talepSatir.findElement(By.xpath(".//span[contains(text(), 'mouse')]"));
        talepSec.click();
        ng.waitForAngularRequestsToFinish();

        WebElement talepSatirTablo = driver.findElement(a.tableTalepItems);
        int talepItemsCount = talepSatirTablo.findElements(By.tagName("tr")).size();
        for(int i=1; i < talepItemsCount; i++){
            WebElement talepItemRow = talepSatirTablo.findElement(By.xpath(".//tbody//tr[" + i +"]"));
            String adet = talepItemRow.findElement(By.xpath(".//td[contains(@class, 'miktar')]")).getText();
            adet = adet.substring(0, adet.indexOf(" "));
            talepItemRow.findElement(By.xpath(".//span[contains(text(), 'mouse')]")).click();
            ng.waitForAngularRequestsToFinish();
            WebElement tedarikciTeklifTablo = talepSatirTablo.findElement(By.xpath(".//following::table"));
            tedarikciTeklifTablo.findElement(By.xpath(".//span[contains(text(), 'create')]")).click();
            ng.waitForAngularRequestsToFinish();
            tedarikciTeklifTablo.findElement(By.cssSelector("input#input-adminBirimFiyati")).sendKeys("3,42");
            tedarikciTeklifTablo.findElement(By.xpath(".//span[contains(text(), 'save')]")).click();
            ng.waitForAngularRequestsToFinish();
            talepSatirTablo.findElement(By.xpath(".//tbody//tr["+ i +"]//td[contains(@class, 'adminTeslimSuresi')]")).click();
            driver.findElement(By.id("input-teslimSuresi")).clear();
            driver.findElement(By.id("input-teslimSuresi")).sendKeys("5");
            driver.findElement(By.cssSelector("mat-select[formcontrolname='teslimSuresiBirimi']")).click();
            driver.findElement(By.cssSelector("mat-option[value='hafta']")).click();
            driver.findElement(By.xpath("//button[contains(.,'TAMAMLA')]")).click();
            ng.waitForAngularRequestsToFinish();
        }

        talepSatir = driver
                .findElement(a.tableTalep)
                .findElement(By.xpath(
                        ".//td[contains(text(),'"+ talepNo +"')]//parent::tr"));
        talepSatir.findElement(By.xpath(".//td[contains(@class,'adminGecerlilikTarihi')]")).click();
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("//button[contains(.,'TAMAMLA')]")).click();
        ng.waitForAngularRequestsToFinish();
        talepSatir.findElement(By.cssSelector("button[mattooltip='Teklif Gönder']")).click();
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("//button[contains(.,'ONAYLIYORUM')]")).click();







    }
}
