package com.firatg.tdkdictionary.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtasozuItem{

	@JsonProperty("on_taki")
	private Object onTaki;

	@JsonProperty("madde_id")
	private String maddeId;

	@JsonProperty("madde")
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