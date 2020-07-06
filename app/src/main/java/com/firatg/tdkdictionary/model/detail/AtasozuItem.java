package com.firatg.tdkdictionary.model.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class AtasozuItem{

	@SerializedName("on_taki")
	private Object onTaki;

	@SerializedName("madde_id")
	private String maddeId;

	@SerializedName("madde")
	private String madde;

	public Object getOnTaki(){
		return onTaki;
	}

	public String getMaddeId(){
		return maddeId;
	}

	public String getMadde(){
		return madde;
	}
}