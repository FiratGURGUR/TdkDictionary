package com.firatg.tdkdictionary.model.homepage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Url implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;


    public Url(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }


    public String getUrl() {
        return url;
    }

}
