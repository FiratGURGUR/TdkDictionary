package com.firatg.tdkdictionary.model.search;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "history_table",indices = {@Index(value = {"word"}, unique = true)})
public class History {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    public int id;
    @SerializedName("word")
    public String word;

    public History(String word) {
        this.word = word;
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

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
