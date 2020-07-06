package com.firatg.tdkdictionary.model.homepage;

import android.text.Html;
import android.text.Spanned;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Yabanci{

	@SerializedName("karsid")
	private String karsid;

	@SerializedName("anlam")
	private String anlam;

	@SerializedName("kkarsilik")
	private String kkarsilik;

	@SerializedName("kkelime")
	private String kkelime;

	@SerializedName("kkoken")
	private String kkoken;

	public String getKarsid(){
		return karsid;
	}

	public String getAnlam(){
		return anlam;
	}

	public String getKkarsilik(){
		return kkarsilik;
	}

	public String getKkelime(){
		return kkelime;
	}

	public String getKkoken(){
		return kkoken;
	}



	public String spannedKoken(){
		return "Köken    :  " + Html.fromHtml(kkoken);
	}
	public String spannedKarsilik(){
		return "Karşılık  :  "+ Html.fromHtml(kkarsilik);
	}
	public String spannedAnlam(){
		return "Anlam    :  "+ Html.fromHtml(anlam);
	}



	@Override
	public String toString() {
		return "Yabanci{" +
				"karsid='" + karsid + '\'' +
				", anlam='" + anlam + '\'' +
				", kkarsilik='" + kkarsilik + '\'' +
				", kkelime='" + kkelime + '\'' +
				", kkoken='" + kkoken + '\'' +
				'}';
	}
}