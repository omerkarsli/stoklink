package com.stoklink.testCases;

import com.stoklink.pageObjects.admin.A_TeklifIslemleri;
import com.stoklink.utils.baseUtils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class AdminTeklifOnayla extends Base {

    @Test
    public void teklifOnayla(ITestContext context){
        adminLogin();
        aTeklifIslemleri = new A_TeklifIslemleri(driver);
        String talepNo = context.getAttribute("talepNo").toString();
        WebElement talepSatir = driver
                .findElement(aTeklifIslemleri.tableTalep)
                .findElement(By.xpath(
                        ".//td[contains(text(),'"+ talepNo +"')]//parent::tr"));

        WebElement talepSec = talepSatir.findElement(By.xpath(".//span[contains(text(), 'mouse')]"));
        talepSec.click();
        ng.waitForAngularRequestsToFinish();

        WebElement talepSatirTablo = driver.findElement(aTeklifIslemleri.tableTalepItems);
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
                .findElement(aTeklifIslemleri.tableTalep)
                .findElement(By.xpath(
                        ".//tr[contains(.,'"+ talepNo +"')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(talepSatir).click(
                talepSatir.findElement(By.xpath(".//td[contains(@class,'adminGecerlilikTarihi')]"))).build().perform();
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("//button[contains(.,'TAMAMLA')]")).click();
        ng.waitForAngularRequestsToFinish();
        talepSatir.findElement(By.cssSelector("button[mattooltip='Teklif G??nder']")).click();
        ng.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("//button[contains(.,'ONAYLIYORUM')]")).click();
        ng.waitForAngularRequestsToFinish();






    }
}
