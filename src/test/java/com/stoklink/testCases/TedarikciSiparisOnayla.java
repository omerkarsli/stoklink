package com.stoklink.testCases;

import com.stoklink.pageObjects.tedarikci.T_SiparisOnay;
import com.stoklink.utils.baseUtils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TedarikciSiparisOnayla extends Base {

    @Test
    public void tSiparisOnayla(ITestContext context){
        String talepNo = context.getAttribute("talepNo").toString();
        tedarikciLogin();
        tSiparisOnay = new T_SiparisOnay(driver);

        tSiparisOnay.clickTedarikciBtn();
        tSiparisOnay.clickSiparisOnay();

        WebElement siparisOnayTablo = driver.findElement(By.tagName("tbody"));
        int talepItemCount = siparisOnayTablo.findElements(By.xpath(".//tr[contains(.,'" + talepNo + "')]")).size();

        for (int i = 1; i < talepItemCount + 1; i++) {
            String talepSatirNo = talepNo + " - " + i;
            WebElement currentRow = siparisOnayTablo.findElement(By.xpath(".//tr[contains(.,'" + talepSatirNo + "')]"));
            tSiparisOnay.siparisOnayla(currentRow);
        }

    }
}
