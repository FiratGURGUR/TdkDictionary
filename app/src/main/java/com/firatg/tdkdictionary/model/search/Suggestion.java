package com.firatg.tdkdictionary.model.search;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "suggest_table")
public class Suggestion {

    @NonNull
    @SerializedName("madde")
    @PrimaryKey(autoGenerate = false)
    public String madde;


    public String getMadde() {
        return madde;
    }

    public void setMadde(String madde) {
        this.madde = madde;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "madde='" + madde + '\'' +
                '}';
    }
}
