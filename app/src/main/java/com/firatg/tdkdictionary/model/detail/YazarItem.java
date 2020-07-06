package com.firatg.tdkdictionary.model.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class YazarItem{

	@SerializedName("yazar_id")
	private String yazarId;

	@SerializedName("tam_adi")
	private String tamAdi;

	@SerializedName("ekno")
	private String ekno;

	@SerializedName("kisa_adi")
	private String kisaAdi;

	public String getYazarId(){
		return yazarId;
	}

	public String getTamAdi(){
		return tamAdi;
	}

	public String getEkno(){
		return ekno;
	}

	public String getKisaAdi(){
		return kisaAdi;
	}
}