package com.firatg.tdkdictionary.model.search;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSearch{

	@JsonProperty("lisan")
	private String lisan;

	@JsonProperty("lisan_kodu")
	private String lisanKodu;

	@JsonProperty("telaffuz")
	private Object telaffuz;

	@JsonProperty("anlamlarListe")
	private List<AnlamlarListeItem> anlamlarListe;

	@JsonProperty("kac")
	private String kac;

	@JsonProperty("ozel_mi")
	private String ozelMi;

	@JsonProperty("on_taki")
	private Object onTaki;

	@JsonProperty("anlam_say")
	private String anlamSay;

	@JsonProperty("anlam_gor")
	private String anlamGor;

	@JsonProperty("gosterim_tarihi")
	private Object gosterimTarihi;

	@JsonProperty("madde_id")
	private String maddeId;

	@JsonProperty("birlesikler")
	private String birlesikler;

	@JsonProperty("cogul_mu")
	private String cogulMu;

	@JsonProperty("madde")
	private String madde;

	@JsonProperty("taki")
	private Object taki;

	@JsonProperty("cesit")
	private String cesit;

	@JsonProperty("cesit_say")
	private String cesitSay;

	@JsonProperty("madde_duz")
	private String maddeDuz;

	@JsonProperty("atasozu")
	private List<AtasozuItem> atasozu;

	@JsonProperty("kelime_no")
	private String kelimeNo;

	@JsonProperty("font")
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
}