package com.firatg.tdkdictionary.model.detail;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ResponseDetail{

	@SerializedName("lisan")
	private String lisan;

	@SerializedName("lisan_kodu")
	private String lisanKodu;

	@SerializedName("telaffuz")
	private Object telaffuz;

	@SerializedName("anlamlarListe")
	private List<AnlamlarListeItem> anlamlarListe;

	@SerializedName("kac")
	private String kac;

	@SerializedName("ozel_mi")
	private String ozelMi;

	@SerializedName("on_taki")
	private Object onTaki;

	@SerializedName("anlam_say")
	private String anlamSay;

	@SerializedName("anlam_gor")
	private String anlamGor;

	@SerializedName("gosterim_tarihi")
	private Object gosterimTarihi;

	@SerializedName("madde_id")
	private String maddeId;

	@SerializedName("birlesikler")
	private String birlesikler;

	@SerializedName("cogul_mu")
	private String cogulMu;

	@SerializedName("madde")
	private String madde;

	@SerializedName("taki")
	private Object taki;

	@SerializedName("cesit")
	private String cesit;

	@SerializedName("cesit_say")
	private String cesitSay;

	@SerializedName("madde_duz")
	private String maddeDuz;

	@SerializedName("atasozu")
	private List<AtasozuItem> atasozu;

	@SerializedName("kelime_no")
	private String kelimeNo;

	@SerializedName("font")
	private Object font;

	public String getLisan(){
		return lisan;
	}

	public String getLisanKodu(){
		return lisanKodu;
	}

	public Object getTelaffuz(){
		return telaffuz;
	}

	public List<AnlamlarListeItem> getAnlamlarListe(){
		return anlamlarListe;
	}

	public String getKac(){
		return kac;
	}

	public String getOzelMi(){
		return ozelMi;
	}

	public Object getOnTaki(){
		return onTaki;
	}

	public String getAnlamSay(){
		return anlamSay;
	}

	public String getAnlamGor(){
		return anlamGor;
	}

	public Object getGosterimTarihi(){
		return gosterimTarihi;
	}

	public String getMaddeId(){
		return maddeId;
	}

	public String getBirlesikler(){
		return birlesikler;
	}

	public String getCogulMu(){
		return cogulMu;
	}

	public String getMadde(){
		return madde;
	}

	public Object getTaki(){
		return taki;
	}

	public String getCesit(){
		return cesit;
	}

	public String getCesitSay(){
		return cesitSay;
	}

	public String getMaddeDuz(){
		return maddeDuz;
	}

	public List<AtasozuItem> getAtasozu(){
		return atasozu;
	}

	public String getKelimeNo(){
		return kelimeNo;
	}

	public Object getFont(){
		return font;
	}

	public String capitalizeDetail(){
		return madde.substring(0, 1).toUpperCase() + madde.substring(1).toLowerCase();
	}

	@Override
	public String toString() {
		return "ResponseDetail{" +
				"lisan='" + lisan + '\'' +
				", lisanKodu='" + lisanKodu + '\'' +
				", telaffuz=" + telaffuz +
				", anlamlarListe=" + anlamlarListe +
				", kac='" + kac + '\'' +
				", ozelMi='" + ozelMi + '\'' +
				", onTaki=" + onTaki +
				", anlamSay='" + anlamSay + '\'' +
				", anlamGor='" + anlamGor + '\'' +
				", gosterimTarihi=" + gosterimTarihi +
				", maddeId='" + maddeId + '\'' +
				", birlesikler='" + birlesikler + '\'' +
				", cogulMu='" + cogulMu + '\'' +
				", madde='" + madde + '\'' +
				", taki=" + taki +
				", cesit='" + cesit + '\'' +
				", cesitSay='" + cesitSay + '\'' +
				", maddeDuz='" + maddeDuz + '\'' +
				", atasozu=" + atasozu +
				", kelimeNo='" + kelimeNo + '\'' +
				", font=" + font +
				'}';
	}
}