package com.firatg.tdkdictionary.repository;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.firatg.tdkdictionary.api.MyApi;
import com.firatg.tdkdictionary.api.MyClient;
import com.firatg.tdkdictionary.api.local.FavoriDao;
import com.firatg.tdkdictionary.api.local.HistoryDao;
import com.firatg.tdkdictionary.api.local.MyDatabase;
import com.firatg.tdkdictionary.api.local.SuggestionDao;
import com.firatg.tdkdictionary.model.detail.ResponseDetail;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;
import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.model.search.Suggestion;
import com.firatg.tdkdictionary.ui.MainActivity;
import com.firatg.tdkdictionary.utils.Statics;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepository {

    public MutableLiveData<List<Suggestion>> sgs =new MutableLiveData<>();
    public MutableLiveData<ResponseDetail> detail =new MutableLiveData<>();
    private SuggestionDao suggestionDao;
    public HistoryDao historyDao;
    public FavoriDao favoriDao;
    private LiveData<List<Suggestion>> listLiveData;
    private LiveData<List<History>> listHistoryLiveData;
    private LiveData<List<Favori>> listFavoriLiveData;
    private LiveData<Favori> tekFavori;


    public SearchRepository(Application application) {
        MyDatabase database = MyDatabase.getInstance(application);
        suggestionDao = database.suggestionDao();
        historyDao = database.historyDao();
        favoriDao = database.favoriDao();
    }

    public void insert(List<Suggestion> list){
        new InsertNoteAsyncTask(suggestionDao).execute(list);
    }

    private static class InsertNoteAsyncTask extends AsyncTask<List<Suggestion>,Void,Void> {
        private SuggestionDao suggestionDao;

        private InsertNoteAsyncTask(SuggestionDao suggestionDao){
            this.suggestionDao = suggestionDao;
        }

        @Override
        protected Void doInBackground(List<Suggestion>... notes) {
            suggestionDao.insert(notes[0]);
            return null;
        }
    }


    public void insertHistoru(History history){
        new InsertHistoryAsyncTask(historyDao).execute(history);
    }

    private static class InsertHistoryAsyncTask extends AsyncTask<History,Void,Void> {
        private HistoryDao historyDao;

        private InsertHistoryAsyncTask(HistoryDao historyDao){
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... notes) {
            historyDao.insert(notes[0]);
            return null;
        }
    }

    public  LiveData<List<Suggestion>> getten(String s){
        listLiveData = suggestionDao.getSuggestions(s);
        return listLiveData;
    }
    public  LiveData<List<History>> gettwel(){
        listHistoryLiveData = historyDao.getHistory();
        return listHistoryLiveData;
    }

    public MutableLiveData<List<Suggestion>> getSgs() {
        MyApi api = MyClient.getInstance().getMyApi();
        Call<List<Suggestion>> call = api.autocompletelist();
        call.enqueue(new Callback<List<Suggestion>>() {
            @Override
            public void onResponse(Call<List<Suggestion>> call, Response<List<Suggestion>> response) {
                insert(response.body());
                Log.i("frt","kaydetti");
            }

            @Override
            public void onFailure(Call<List<Suggestion>> call, Throwable t) {
            }
        });
        return sgs;
    }


    public MutableLiveData<ResponseDetail> getDetail(String s) {
        MyApi api = MyClient.getInstance().getMyApi();
        Call<List<ResponseDetail>> call = api.getDetail(s);
        call.enqueue(new Callback<List<ResponseDetail>>() {
            @Override
            public void onResponse(Call<List<ResponseDetail>> call, Response<List<ResponseDetail>> response) {
                detail.postValue(response.body().get(0));
                insertHistoru(new History(response.body().get(0).getMadde()));
            }

            @Override
            public void onFailure(Call<List<ResponseDetail>> call, Throwable t) {
            Log.i("frt","hata");
            }
        });
        return detail;
    }

    public void deleteAllHistory(){
        new DeleteAllHistoryAsyncTask(historyDao).execute();
    }
    public static class DeleteAllHistoryAsyncTask extends AsyncTask<Void,Void,Void>{
        HistoryDao historyDao;
        private DeleteAllHistoryAsyncTask(HistoryDao historyDao){
            this.historyDao = historyDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            historyDao.deleteHistory();
            return null;
        }
    }



    public void insertFavori(Favori favori){
        new InsertFavoriAsyncTask(favoriDao).execute(favori);
    }

    private static class InsertFavoriAsyncTask extends AsyncTask<Favori,Void,Void> {
        private FavoriDao favoriDao;

        private InsertFavoriAsyncTask(FavoriDao favoriDao){
            this.favoriDao = favoriDao;
        }

        @Override
        protected Void doInBackground(Favori... notes) {
            favoriDao.insert(notes[0]);
            return null;
        }
    }

    public  LiveData<List<Favori>> getFavList(){
        listFavoriLiveData = favoriDao.getFavoriList();
        return listFavoriLiveData;
    }

    public LiveData<Favori> getTek(String word){
        tekFavori = favoriDao.getSingleWord(word);
        return tekFavori;
    }



    public void update(Favori favori){
        new UpdateNoteAsyncTask(favoriDao).execute(favori);
    }
    private static class UpdateNoteAsyncTask extends AsyncTask<Favori,Void,Void>{
        private FavoriDao favoriDao;

        private UpdateNoteAsyncTask(FavoriDao favoriDao){
            this.favoriDao = favoriDao;
        }

        @Override
        protected Void doInBackground(Favori... notes) {
            favoriDao.update(notes[0]);
            return null;
        }
    }


}
