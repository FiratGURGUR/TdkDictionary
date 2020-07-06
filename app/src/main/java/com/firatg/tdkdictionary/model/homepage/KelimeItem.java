package com.firatg.tdkdictionary.model.homepage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class KelimeItem{

	@SerializedName("anlam")
	private String anlam;

	@SerializedName("madde")
	private String madde;

	public String getAnlam(){
		return anlam;
	}

	public String getMadde(){
		return madde;
	}
}