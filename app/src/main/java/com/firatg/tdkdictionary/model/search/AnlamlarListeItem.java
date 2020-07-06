package com.firatg.tdkdictionary.model.search;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnlamlarListeItem{

	@JsonProperty("tipkes")
	private String tipkes;

	@JsonProperty("ozelliklerListe")
	private List<OzelliklerListeItem> ozelliklerListe;

	@JsonProperty("anlam")
	private String anlam;

	@JsonProperty("madde_id")
	private String maddeId;

	@JsonProperty("fiil")
	private String fiil;

	@JsonProperty("gos")
	private String gos;

	@JsonProperty("anlam_id")
	private String anlamId;

	@JsonProperty("anlam_sira")
	private String anlamSira;

	@JsonProperty("orneklerListe")
	private List<OrneklerListeItem> orneklerListe;

	public String getTipkes(){
		return tipkes;
	}

	public List<OzelliklerListeItem> getOzelliklerListe(){
		return ozelliklerListe;
	}

	public String getAnlam(){
		return anlam;
	}

	public String getMaddeId(){
		return maddeId;
	}

	public String getFiil(){
		return fiil;
	}

	public String getGos(){
		return gos;
	}

	public String getAnlamId(){
		return anlamId;
	}

	public String getAnlamSira(){
		return anlamSira;
	}

	public List<OrneklerListeItem> getOrneklerListe(){
		return orneklerListe;
	}
}