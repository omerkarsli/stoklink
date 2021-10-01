package com.stoklink.API.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Marka {

	private String ad;

	public Marka() {
	}

	public Marka(String ad) {
		this.ad = ad;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Marka [ad=" + ad + "]";
	}
}
