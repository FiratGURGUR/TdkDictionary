package com.firatg.tdkdictionary.model.search;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "fav_table",indices = {@Index(value = {"word","id"}, unique = true)})
public class Favori {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;
    @SerializedName("word")
    public String word;
    @SerializedName("like")
    public boolean like;

    public Favori(String word,boolean like) {
        this.word = word;
        this.like = like;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Favori{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", like=" + like +
                '}';
    }
}
