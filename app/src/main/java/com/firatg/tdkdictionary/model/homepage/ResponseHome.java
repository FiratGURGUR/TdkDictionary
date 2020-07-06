package com.firatg.tdkdictionary.model.homepage;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ResponseHome{

	@SerializedName("atasoz")
	private List<AtasozItem> atasoz;

	@SerializedName("syyd")
	private List<SyydItem> syyd;

	@SerializedName("yabanci")
	private Yabanci yabanci;

	@SerializedName("kelime")
	private List<KelimeItem> kelime;

	@SerializedName("kural")
	private List<KuralItem> kural;

	@SerializedName("karistirma")
	private List<KaristirmaItem> karistirma;

	@SerializedName("sayac")
	private List<SayacItem> sayac;

	public List<AtasozItem> getAtasoz(){
		return atasoz;
	}

	public List<SyydItem> getSyyd(){
		return syyd;
	}

	public Yabanci getYabanci(){
		return yabanci;
	}

	public List<KelimeItem> getKelime(){
		return kelime;
	}

	public List<KuralItem> getKural(){
		return kural;
	}

	public List<KaristirmaItem> getKaristirma(){
		return karistirma;
	}

	public List<SayacItem> getSayac(){
		return sayac;
	}

	public String capitalizeTittle(){
		return yabanci.getKkelime().substring(0, 1).toUpperCase() + yabanci.getKkelime().substring(1).toLowerCase();
	}


	@Override
	public String toString() {
		return "yabanci : " + yabanci;
	}
}