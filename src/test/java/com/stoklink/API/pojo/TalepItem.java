package com.stoklink.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TalepItem {

	private String aciklama;
	private String birim;
	private String durum;
	private Marka marka;
	private String miktar;
	private Boolean muadil;
	private Boolean stok;
	private Urun urun;
	private String urunIsim;

	public TalepItem(String aciklama, String birim, String durum, Marka marka, String miktar, Boolean muadil,
			Boolean stok, Urun urun, String urunIsim) {
		this.aciklama = aciklama;
		this.birim = birim;
		this.durum = durum;
		this.marka = marka;
		this.miktar = miktar;
		this.muadil = muadil;
		this.stok = stok;
		this.urun = urun;
		this.urunIsim = urunIsim;
	}

	public TalepItem() {
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getBirim() {
		return birim;
	}

	public void setBirim(String birim) {
		this.birim = birim;
	}

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	public String getMiktar() {
		return miktar;
	}

	public void setMiktar(String miktar) {
		this.miktar = miktar;
	}

	public Boolean getMuadil() {
		return muadil;
	}

	public void setMuadil(Boolean muadil) {
		this.muadil = muadil;
	}

	public Boolean getStok() {
		return stok;
	}

	public void setStok(Boolean stok) {
		this.stok = stok;
	}

	public Urun getUrun() {
		return urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	public String getUrunIsim() {
		return urunIsim;
	}

	public void setUrunIsim(String urunIsim) {
		this.urunIsim = urunIsim;
	}

	@Override
	public String toString() {
		return "aciklama=" + aciklama + ", birim=" + birim + ", durum=" + durum + ", marka=" + marka + ", miktar="
				+ miktar + ", muadil=" + muadil + ", stok=" + stok + ", urun=" + urun + ", urunIsim=" + urunIsim;
	}

}
