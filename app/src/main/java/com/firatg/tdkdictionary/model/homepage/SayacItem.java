package com.firatg.tdkdictionary.model.homepage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class SayacItem{

	@SerializedName("deger")
	private String deger;

	public String getDeger(){
		return deger;
	}
}