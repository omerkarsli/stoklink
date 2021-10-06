package com.stoklink.testCases;

import com.stoklink.pageObjects.tedarikci.T_TeklifAraVer;
import com.stoklink.utils.baseUtils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TedarikciTeklifVer extends Base {

    @Test
    public void teklifVer(ITestContext context) throws InterruptedException {
        String talepNo = context.getAttribute("talepNo").toString();
        tedarikciLogin();
        tTeklifAraVer = new T_TeklifAraVer(driver);
        tTeklifAraVer.clickTedarikciBtn();
        ng.waitForAngularRequestsToFinish();
        tTeklifAraVer.clickTeklifAraVer();
        ng.waitForAngularRequestsToFinish();
        for (int i = 1; i < 3; i++) {
            String talepItem = talepNo + " - " + i;
            By byRow = By.xpath("//td[contains(text(),'"+ talepNo +"')]//parent::tr");
            String birim = driver.findElement(By.xpath("//td[contains(text(),'"+ talepNo +"')]//following-sibling::td[5]")).getText();
            birim = birim.substring(0,birim.indexOf(" "));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(byRow).findElement(By.xpath(".//span[contains(text(), 'create')]")))).click();
            WebElement expandedRow = driver.findElement(byRow).findElement(By.xpath(".//following-sibling::tr"));
            expandedRow.findElement(By.name("miktar")).sendKeys(birim);
            expandedRow.findElement(By.name("birimFiyat")).sendKeys("2,55");
            WebElement matSelect = expandedRow.findElement(By.xpath(".//mat-select[@formcontrolname='paraBirimi']"));
            matSelect.click();
            matSelect.sendKeys(Keys.ENTER);
            expandedRow.findElement(By.name("teslimSuresi")).sendKeys("3");
            matSelect =  expandedRow.findElement(By.xpath(".//mat-select[@formcontrolname='teslimSuresiBirimi']"));
            matSelect.click();
            matSelect.sendKeys(Keys.ENTER);
            driver.findElement(byRow).findElement(By.xpath(".//span[contains(text(),'save')]")).click();
            ng.waitForAngularRequestsToFinish();
        }



    }
}
