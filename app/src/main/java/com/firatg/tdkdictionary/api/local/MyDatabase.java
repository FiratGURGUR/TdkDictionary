package com.firatg.tdkdictionary.api.local;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.model.search.Suggestion;

@Database(entities = {Suggestion.class, History.class, Favori.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract SuggestionDao suggestionDao();
    public abstract HistoryDao historyDao();
    public abstract FavoriDao favoriDao();

    public static synchronized MyDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,"suggestion_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private SuggestionDao suggestionDao;
        private HistoryDao historyDao;
        private FavoriDao favoriDao;

        private PopulateDbAsyncTask(MyDatabase db){
            historyDao = db.historyDao();
            suggestionDao = db.suggestionDao();
            favoriDao = db.favoriDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }


}
