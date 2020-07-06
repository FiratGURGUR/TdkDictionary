package com.firatg.tdkdictionary.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YazarItem{

	@JsonProperty("yazar_id")
	private String yazarId;

	@JsonProperty("tam_adi")
	private String tamAdi;

	@JsonProperty("ekno")
	private String ekno;

	@JsonProperty("kisa_adi")
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