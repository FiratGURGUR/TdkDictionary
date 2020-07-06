package com.firatg.tdkdictionary.api.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.firatg.tdkdictionary.model.search.Suggestion;

import java.util.List;

@Dao
public interface SuggestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Suggestion> autocom);

    @Query("SELECT * FROM suggest_table WHERE madde LIKE :s || '%' LIMIT 20")
    LiveData<List<Suggestion>> getSuggestions(String s);

}
