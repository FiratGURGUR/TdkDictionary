package com.firatg.tdkdictionary.model.detail;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class AnlamlarListeItem{

	@SerializedName("tipkes")
	private String tipkes;

	@SerializedName("ozelliklerListe")
	private List<OzelliklerListeItem> ozelliklerListe;

	@SerializedName("anlam")
	private String anlam;

	@SerializedName("madde_id")
	private String maddeId;

	@SerializedName("fiil")
	private String fiil;

	@SerializedName("gos")
	private String gos;

	@SerializedName("anlam_id")
	private String anlamId;

	@SerializedName("anlam_sira")
	private String anlamSira;

	@SerializedName("orneklerListe")
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