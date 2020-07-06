package com.firatg.tdkdictionary.model.homepage;

import com.google.gson.annotations.SerializedName;

public class AtasozItem{

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