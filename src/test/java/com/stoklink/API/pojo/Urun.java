package com.stoklink.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Urun {

	private String referans;
	private String isim;
	private String birim;
	private String kategori;
	private String siparisKodu;
	private String aciklama;
	private String stoklinkAciklama;
	private Marka marka;

	public Urun() {

	}

	public Urun(String referans, String birim) {
		this.referans = referans;
		this.birim = birim;
	}

	public Urun(String referans, String isim, String birim, String kategori, String token) {
		this.referans = referans;
		this.isim = isim;
		this.birim = birim;
		this.kategori = kategori;

	}

	public String getSiparisKodu() {
		return siparisKodu;
	}

	public void setSiparisKodu(String siparisKodu) {
		this.siparisKodu = siparisKodu;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getStoklinkAciklama() {
		return stoklinkAciklama;
	}

	public void setStoklinkAciklama(String stoklinkAciklama) {
		this.stoklinkAciklama = stoklinkAciklama;
	}

	public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

	public String getReferans() {
		return referans;
	}

	public void setReferans(String referans) {
		this.referans = referans;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getBirim() {
		return birim;
	}

	public void setBirim(String birim) {
		this.birim = birim;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	@Override
	public String toString() {
		return "referans=" + referans + ", isim=" + isim + ", birim=" + birim + ", kategori=" + kategori;
	}

}
