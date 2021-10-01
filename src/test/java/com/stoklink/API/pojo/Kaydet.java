package com.stoklink.API.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Kaydet {

	private int durum;
	private String gecerlilikTarihi;
	private List<TalepItem> talepItemList;

	public Kaydet() {
	}

	public Kaydet(int durum, String gecerlilikTarihi, List<TalepItem> talepItemList) {
		this.durum = durum;
		this.gecerlilikTarihi = gecerlilikTarihi;
		this.talepItemList = talepItemList;
	}

	public int getDurum() {
		return durum;
	}

	public void setDurum(int durum) {
		this.durum = durum;
	}

	public String getGecerlilikTarihi() {
		return gecerlilikTarihi;
	}

	public void setGecerlilikTarihi(String gecerlilikTarihi) {
		this.gecerlilikTarihi = gecerlilikTarihi;
	}

	public List<TalepItem> getTalepItemList() {
		return talepItemList;
	}

	public void setTalepItemList(List<TalepItem> talepItemList) {
		this.talepItemList = talepItemList;
	}

	@Override
	public String toString() {
		return "durum=" + durum + ", gecerlilikTarihi=" + gecerlilikTarihi + ", talepItemList=" + talepItemList;
	}

}
