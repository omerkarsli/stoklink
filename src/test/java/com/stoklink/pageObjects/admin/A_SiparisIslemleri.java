package com.stoklink.pageObjects.admin;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A_SiparisIslemleri extends A_Menu{

    public A_SiparisIslemleri(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "tbody")
    public WebElement siparisTablo;

    public void siparisGonder(WebElement row){
        WebElement siparisGonderBtn = row.findElement(By.cssSelector("button[mattooltip='Sipariş Gönder']"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(siparisGonderBtn))
                .click();

        ng.waitForAngularRequestsToFinish();

        WebElement onaylaBtn = driver.findElement(By.xpath("//button[contains(.,'ONAYLIYORUM')]"));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(onaylaBtn))
                .click();

        ng.waitForAngularRequestsToFinish();
    }


}
