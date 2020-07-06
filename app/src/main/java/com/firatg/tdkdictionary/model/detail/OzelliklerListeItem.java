package com.firatg.tdkdictionary.model.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class OzelliklerListeItem{

	@SerializedName("tur")
	private String tur;

	@SerializedName("tam_adi")
	private String tamAdi;

	@SerializedName("ekno")
	private String ekno;

	@SerializedName("ozellik_id")
	private String ozellikId;

	@SerializedName("kisa_adi")
	private String kisaAdi;

	public String getTur(){
		return tur;
	}

	public String getTamAdi(){
		return tamAdi;
	}

	public String getEkno(){
		return ekno;
	}

	public String getOzellikId(){
		return ozellikId;
	}

	public String getKisaAdi(){
		return kisaAdi;
	}
}