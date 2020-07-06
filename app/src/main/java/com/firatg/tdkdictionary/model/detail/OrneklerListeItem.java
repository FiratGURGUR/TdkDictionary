package com.firatg.tdkdictionary.model.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class OrneklerListeItem{

	@SerializedName("ornek")
	private String ornek;

	@SerializedName("yazar_id")
	private String yazarId;

	@SerializedName("ornek_id")
	private String ornekId;

	@SerializedName("anlam_id")
	private String anlamId;

	@SerializedName("ornek_sira")
	private String ornekSira;

	@SerializedName("kac")
	private String kac;

	public String getOrnek(){
		return ornek;
	}

	public String getYazarId(){
		return yazarId;
	}

	public String getOrnekId(){
		return ornekId;
	}

	public String getAnlamId(){
		return anlamId;
	}

	public String getOrnekSira(){
		return ornekSira;
	}

	public String getKac(){
		return kac;
	}
}