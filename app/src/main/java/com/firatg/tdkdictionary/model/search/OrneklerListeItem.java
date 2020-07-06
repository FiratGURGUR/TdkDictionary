package com.firatg.tdkdictionary.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrneklerListeItem{

	@JsonProperty("ornek")
	private String ornek;

	@JsonProperty("yazar_id")
	private String yazarId;

	@JsonProperty("ornek_id")
	private String ornekId;

	@JsonProperty("anlam_id")
	private String anlamId;

	@JsonProperty("ornek_sira")
	private String ornekSira;

	@JsonProperty("kac")
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