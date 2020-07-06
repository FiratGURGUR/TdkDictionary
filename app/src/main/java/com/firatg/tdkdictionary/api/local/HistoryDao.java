package com.firatg.tdkdictionary.api.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.model.search.Suggestion;

import java.util.List;

@Dao
public interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History history);

    @Query("SELECT * FROM history_table ORDER BY id DESC")
    LiveData<List<History>> getHistory();


    @Query("DELETE FROM history_table")
    void deleteHistory();


}
