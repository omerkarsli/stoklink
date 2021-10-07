package com.stoklink.testCases;

import com.stoklink.pageObjects.admin.A_SiparisIslemleri;
import com.stoklink.utils.baseUtils.Base;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class AdminSiparisOnayla extends Base {

    @Test
    public void aSiparisOnayla(ITestContext context){
        String talepNo = context.getAttribute("talepNo").toString();
        adminLogin();
        aSiparisIslemleri = new A_SiparisIslemleri(driver);
        aSiparisIslemleri.clickSiparisIslemleri();

        WebElement row = driver.findElement(By.xpath("//tr[contains(.,'" + talepNo + "')]"));
        aSiparisIslemleri.siparisGonder(row);
    }
}
