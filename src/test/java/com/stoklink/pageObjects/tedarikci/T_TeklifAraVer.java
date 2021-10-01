package com.stoklink.pageObjects.tedarikci;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class T_TeklifAraVer extends T_Menu {

	public T_TeklifAraVer(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//mat-select[@formcontrolname='durum']")
	@CacheLookup
	public WebElement durum;

	@FindBy(xpath = "//input[@formcontrolname='baslangicTarihi']")
	@CacheLookup
	public WebElement baslangicTarihi;

	@FindBy(xpath = "//input[@formcontrolname='bitisTarihi']")
	@CacheLookup
	public WebElement bitisTarihi;

	@FindBy(xpath = "//span[contains(text(), 'filtrele')]")
	@CacheLookup
	public WebElement filtrele;

	public void teklifVer(int rowIndex) throws InterruptedException {
		String row = ".//tr[" + (rowIndex * 2 + 1) + "]";
		By createXpath = By.xpath(row + "//span[contains(text(), 'create')]");
		By amount = By.xpath(row + "//td[6]");
		By table = By.tagName("table");
		String setAmount = driver.findElement(table).findElement(amount).getText();
		setAmount = setAmount.substring(0, setAmount.indexOf(" "));
		driver.findElement(table).findElement(createXpath).click();
		Thread.sleep(500);
		WebElement teklifRow = driver.findElement(By.tagName("table"))
				.findElement(By.xpath(".//tr[" + (rowIndex * 2 + 2) + "]"));
		WebElement teklifVerAmount = teklifRow.findElement(By.xpath(".//input[@formcontrolname='miktar']"));
		WebElement birimFiyat = teklifRow.findElement(By.xpath(".//input[@formcontrolname='birimFiyat']"));
		WebElement teslimSuresi = teklifRow.findElement(By.xpath(".//input[@formcontrolname='teslimSuresi']"));
		WebElement teslimSuresiBirimi = teklifRow
				.findElement(By.xpath(".//mat-select[@formcontrolname='teslimSuresiBirimi']"));

		teklifVerAmount.sendKeys(setAmount);
		birimFiyat.sendKeys("2,55");
		teslimSuresi.sendKeys("3");
		teslimSuresiBirimi.click();
		int check = (int) Math.floor(Math.random() * 3);
		for (int i = 0; i < check; i++) {
			teslimSuresiBirimi.sendKeys(Keys.ARROW_DOWN);
		}
		teslimSuresiBirimi.sendKeys(Keys.ENTER);

	}
}
