package com.firatg.tdkdictionary.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OzelliklerListeItem{

	@JsonProperty("tur")
	private String tur;

	@JsonProperty("tam_adi")
	private String tamAdi;

	@JsonProperty("ekno")
	private String ekno;

	@JsonProperty("ozellik_id")
	private String ozellikId;

	@JsonProperty("kisa_adi")
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