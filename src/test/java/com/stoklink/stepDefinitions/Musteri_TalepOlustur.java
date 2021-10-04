package com.stoklink.stepDefinitions;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.stoklink.pageObjects.Login;
import com.stoklink.pageObjects.musteri.M_TalepOlustur;
import com.stoklink.pageObjects.musteri.M_Talepler;
import com.stoklink.utils.baseUtils.Base;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class Musteri_TalepOlustur extends Base implements En {


	public Musteri_TalepOlustur() {

		Given("^Acilmis bir browserda musteri kullanici adi ve sifreyle sisteme giris yapar$", (DataTable table) -> {
			List<List<String>> rows = table.cells();
			String username = rows.get(1).get(0);
			String password = rows.get(1).get(1);
			login = new Login(driver);
			login.setTxtUserName(username);
			login.setTxtPassword(password);
			login.clickLogin();

		});

		And("^Musteri talep olustur sayfasina gider$", () -> {

			wait = new WebDriverWait(driver, 10);
			mTalepler = new M_Talepler(driver);
			if (mTalepler.isTedarikci()) {
				mTalepler.musteriMenu.click();
			}
			wait.until(ExpectedConditions.elementToBeClickable(mTalepler.talepOlustur));
			mTalepler.talepOlustur.click();

		});
		When("^Musteri talep olusturur$", (DataTable table) -> {
			mTalepOlustur = new M_TalepOlustur(driver);
			List<List<String>> data = table.asLists();
			for (int i = 1; i < data.size(); i++) {
				String urunKodu = data.get(i).get(0);
				boolean muadil = Boolean.parseBoolean(data.get(i).get(1));
				boolean stok = Boolean.parseBoolean(data.get(i).get(2));
				String urunMiktari = data.get(i).get(3);
				String aciklama = data.get(i).get(4);
				mTalepOlustur.addProductItem(urunKodu, muadil, stok, urunMiktari, aciklama);
			}
//			mTalepOlustur.save("teklif");
		});
		Then("^Musteri olusturdugu talebi talepler sayfasinda gormelidir$", () -> {
			mTalepOlustur.cikisyap.click();
		});
	}
}
