package com.stoklink.pageObjects.tedarikci;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class T_TeklifAraVer extends T_Menu {

	public T_TeklifAraVer(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "mat-select[formcontrolname='durum']")
	@CacheLookup
	public WebElement durum;

	@FindBy(css = "input[formcontrolname='baslangicTarihi']")
	@CacheLookup
	public WebElement baslangicTarihi;

	@FindBy(css = "input[formcontrolname='bitisTarihi']")
	@CacheLookup
	public WebElement bitisTarihi;

	@FindBy(xpath = "//span[contains(text(), 'filtrele')]")
	@CacheLookup
	public WebElement filtrele;

	public void teklifVer(String talepNo) throws InterruptedException {
		String rowXpath = "//tr[contains(text(),'" + talepNo + "')]";
		By createXpath = By.xpath(rowXpath + "//span[contains(text(), 'create')]");
		By amount = By.xpath(rowXpath + "//td[6]");
		By table = By.tagName("table");
		String setAmount = driver.findElement(table).findElement(amount).getText();
		setAmount = setAmount.substring(0, setAmount.indexOf(" "));
		driver.findElement(table).findElement(createXpath).click();
		new NgWebDriver((JavascriptExecutor)driver).waitForAngularRequestsToFinish();
		WebElement teklifRow = driver.findElement(By.tagName("table"))
				.findElement(By.xpath(rowXpath + "//following-sibling::tr"));
		WebElement teklifVerAmount = teklifRow.findElement(By.xpath(".//input[@formcontrolname='miktar']"));
		WebElement birimFiyat = teklifRow.findElement(By.xpath(".//input[@formcontrolname='birimFiyat']"));
		WebElement teslimSuresi = teklifRow.findElement(By.xpath(".//input[@formcontrolname='teslimSuresi']"));
		WebElement teslimSuresiBirimi = teklifRow
				.findElement(By.xpath(".//mat-select[@formcontrolname='teslimSuresiBirimi']"));

		teklifVerAmount.sendKeys(setAmount);
		birimFiyat.sendKeys("2,55");
		birimFiyat.sendKeys(Keys.TAB);
		WebElement active = driver.switchTo().activeElement();
		active.click();
		active.sendKeys(Keys.ENTER);
		teslimSuresi.sendKeys("3");
		teslimSuresiBirimi.click();
		int check = (int) Math.floor(Math.random() * 3);
		for (int i = 0; i < check; i++) {
			teslimSuresiBirimi.sendKeys(Keys.ARROW_DOWN);
		}
		teslimSuresiBirimi.sendKeys(Keys.ENTER);

	}


}
