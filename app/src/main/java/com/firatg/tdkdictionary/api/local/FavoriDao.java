package com.firatg.tdkdictionary.api.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.firatg.tdkdictionary.model.search.Favori;
import java.util.List;

@Dao
public interface FavoriDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Favori favori);

    @Query("SELECT * FROM fav_table WHERE `like`= 1 ORDER BY id DESC")
    LiveData<List<Favori>> getFavoriList();

    @Query("DELETE FROM fav_table ")
    void deleteFavoriList();

    @Query("SELECT * FROM fav_table WHERE word = :word limit 1")
    LiveData<Favori>  getSingleWord(String word);

    @Update
    void update(Favori favori);

}
