package com.stoklink.stepDefinitions;

import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stoklink.pageObjects.Login;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.Features.Base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class Musteri_TalepOlustur extends Base implements En {


	public Musteri_TalepOlustur() {

		Given("^Acilmis bir browserda musteri kullanici adi ve sifreyle sisteme giris yapar$", (DataTable table) -> {
			Map<String, String> map= table.asMaps().get(0);
			String username = map.get("kullaniciAdi");
			String password = map.get("sifre");
			login = new Login(driver);
			login.setTxtUserName(username);
			login.setTxtPassword(password);
			login.clickLogin();

		});

		When("^Musteri talep olustur sayfasina gider$", () -> {

			wait = new WebDriverWait(driver, 10);
			mTalepler = new M_Talepler(driver);
			if (mTalepler.isTedarikci()) {
				mTalepler.musteriMenu.click();
			}
			wait.until(ExpectedConditions.elementToBeClickable(mTalepler.talepOlustur)).click();
			mTalepOlustur = new M_TalepOlustur(driver);

		});



		And("^Musteri urun satirini doldurur$", (DataTable table) -> {
			Map<String, String> map = table.asMaps().get(0);
			mTalepOlustur.addProductItem(
					map.get("urunKodu"),
					Boolean.parseBoolean(map.get("muadil")),
					Boolean.parseBoolean(map.get("stok")),
					map.get("urunMiktari"),
					map.get("aciklama"));
		});



		And("^Musteri teklif iste butonuna tiklar$", () -> {
			String talepNo = mTalepOlustur.save("teklif");
		});


		Then("^Musteri olusturdugu talebi talepler sayfasinda gormelidir$", () -> {
			mMenu.talepler.click();
			mTalepOlustur.cikisyap.click();
		});
	}
}
