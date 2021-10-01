package com.stoklink.pageObjects.musteri;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class M_TalepOlustur extends M_Menu {

	public int lastRowIndex = driver.findElements(By.tagName("tr")).size() - 2;

	public M_TalepOlustur(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-searchText")
	public WebElement talepIsim;

	@FindBy(xpath = "//input[@placeholder='Tarih Seç']")
	public WebElement talepKapanisTarihi;


	@FindBy(xpath = "//span[contains(text(),'Hızlı Seç')]")
	public WebElement  hizliSec;

	@FindBy(xpath = "//button[@mattooltip='Yeni Satır Ekle']")
	public WebElement yeniSatir;

	@FindBy(xpath = "//span[contains(text(), 'Taslak Olarak Kaydet')]")
	public WebElement taslakKaydet;

	@FindBy(xpath = "//span[contains(text(), 'Teklif İste')]")
	public WebElement teklifIste;

	By table = By.xpath("//table[@formarrayname='talepler']//tbody");
	By row ,urunNo, marka, miktar, aciklama, muadil, stok;


	public void getProductItemAdress(int rowIndex){
		row = By.xpath("//tr[" + String.valueOf( rowIndex + 1) + "]");
		urunNo = By.xpath("//input[@tabindex='" + (rowIndex * 10 + 1) + "']");
		marka = By.xpath("//input[@tabindex='" + (rowIndex * 10 + 2) + "']");
		miktar = By.xpath("//input[@tabindex='" + (rowIndex * 10 + 5) + "']");
		aciklama = By.xpath("//input[@tabindex='" + (rowIndex * 10 + 7) + "']");
		muadil = By.xpath("//tr[" + String.valueOf(rowIndex + 1) + "]//mat-slide-toggle[@formcontrolname='muadil']");
		stok = By.xpath("//tr[" + String.valueOf(rowIndex + 1) + "]//mat-slide-toggle[@formcontrolname='stok']");
	}
	//todo return type eklenecek
	public void save(String type) {
		if(type.equals("taslak")){
			taslakKaydet.click();

		}else if(type.equals("teklif")){
			teklifIste.click();
		}
		driver.findElement(By.xpath("//span[contains(text(), 'KAPAT')]")).click();
	}

    public void addProductItem(String val_refNo, boolean val_muadil, boolean val_stok, String val_amount, String val_aciklama)
            throws InterruptedException {

		if(lastRowIndex !=0){
			yeniSatir.click();
		}
		setProductItem(lastRowIndex, val_refNo, val_muadil, val_stok, val_amount, val_aciklama);
		lastRowIndex +=1;
    }
	public void setProductItem(int rowIndex, String val_refNo, boolean val_muadil, boolean val_stok, String val_amount, String val_aciklama) {
		getProductItemAdress(rowIndex);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if (!StringUtils.isBlank(val_refNo)) {
			driver.findElement(urunNo).clear();
			driver.findElement(urunNo).sendKeys(val_refNo);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mat-option-text']")));
			driver.findElement(urunNo).sendKeys(Keys.ENTER);
		}
		if (val_muadil ^ driver.findElement(muadil).findElement(By.tagName("input")).getAttribute("aria-checked").equals("true")) {
			driver.findElement(muadil).click();
		}


		if (val_stok ^ driver.findElement(stok).findElement(By.tagName("input")).getAttribute("aria-checked").equals("true")) {
			driver.findElement(stok).click();
		}
		if (!StringUtils.isBlank(val_amount)) {
			driver.findElement(miktar).clear();
			driver.findElement(miktar).sendKeys(val_amount);
		}
		if (!StringUtils.isBlank(val_aciklama)) {
			driver.findElement(aciklama).clear();
			driver.findElement(aciklama).sendKeys(val_aciklama);
		}
	}
	public void removeProductItem(int rowIndex) {
		driver.findElement(table).findElement(By.xpath("//tr["+ (rowIndex + 1) +"]//span[contains(text(), 'delete')]")).click();
		lastRowIndex-=1;
	}
}
