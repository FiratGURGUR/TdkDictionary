package com.firatg.tdkdictionary.model.homepage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class KuralItem{

	@SerializedName("adi")
	private String adi;

	@SerializedName("url")
	private String url;

	public String getAdi(){
		return adi;
	}

	public String getUrl(){
		return url;
	}


	public KuralItem(String adi, String url) {
		this.adi = adi;
		this.url = url;
	}
}