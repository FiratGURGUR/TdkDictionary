package com.firatg.tdkdictionary.model.homepage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class SyydItem{

	@SerializedName("dogrukelime")
	private String dogrukelime;

	@SerializedName("yanliskelime")
	private String yanliskelime;

	@SerializedName("id")
	private String id;

	public String getDogrukelime(){
		return dogrukelime;
	}

	public String getYanliskelime(){
		return yanliskelime;
	}

	public String getId(){
		return id;
	}
}