package com.firatg.tdkdictionary.model.homepage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class KaristirmaItem{

	@SerializedName("yanlis")
	private String yanlis;

	@SerializedName("dogru")
	private String dogru;

	@SerializedName("id")
	private String id;

	public String getYanlis(){
		return yanlis;
	}

	public String getDogru(){
		return dogru;
	}

	public String getId(){
		return id;
	}
}