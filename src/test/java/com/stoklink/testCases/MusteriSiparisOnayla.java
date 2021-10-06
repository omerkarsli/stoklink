package com.stoklink.testCases;

import com.stoklink.pageObjects.musteri.M_Siparisler;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.utils.baseUtils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class MusteriSiparisOnayla extends Base {


    @Test
    public void siparisOnayla(ITestContext context){
       String talepNo = context.getAttribute("talepNo").toString();
        musteriLogin();
        mTalepler = new M_Talepler(driver);

        if (mTalepler.isTedarikci()) {
            mTalepler.clickMusteriMenu();
        }

        mTalepler.clickSiparisler();

        mSiparisler = new M_Siparisler(driver);

        WebElement talepSatir = driver.findElement(By.xpath("//tr[contains(.,'"+ talepNo +"')]"));
        mSiparisler.clickTalepSec(talepSatir);
        int itemCount = mSiparisler.siparisListe.findElements(By.tagName("tr")).size();

        for (int i = 0; i < itemCount; i++) {
              WebElement currentRow = mSiparisler.siparisListe.findElement(By.xpath(".//tr[1]"));
              mSiparisler.muadilOnayla(currentRow);
              mSiparisler.sepeteEkle(currentRow);
        }

        mSiparisler.siparisVer();
    }
}
