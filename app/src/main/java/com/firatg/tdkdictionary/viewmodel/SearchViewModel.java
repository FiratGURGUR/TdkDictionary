package com.firatg.tdkdictionary.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.firatg.tdkdictionary.model.detail.ResponseDetail;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;
import com.firatg.tdkdictionary.model.search.Favori;
import com.firatg.tdkdictionary.model.search.History;
import com.firatg.tdkdictionary.model.search.Suggestion;
import com.firatg.tdkdictionary.repository.SearchRepository;
import com.firatg.tdkdictionary.utils.Statics;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
   private SearchRepository searchRepository;
    private LiveData<List<Suggestion>> all;
    private LiveData<List<History>> historylist;
    private LiveData<List<Favori>> favlist;
    private LiveData<Favori> favoriLiveData;
    public LiveData<ResponseDetail> detayo;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        searchRepository = new SearchRepository(application);
    }


    //live
    public LiveData<List<Suggestion>> gets() {
        return searchRepository.getSgs();
    }

    //room
    public LiveData<List<Suggestion>> getAllNotes(String s){
        all = searchRepository.getten(s);
        return all;
    }

    //room history list
    public LiveData<List<History>> getHistorylist(){
        historylist = searchRepository.gettwel();
        return historylist;
    }

    //buraya history ekleme yapılacak repository de yazdım sadece buradan yol olacak
    public void insert(History history){
         searchRepository.insertHistoru(history);
    }

    public void deleteHistory(){
        searchRepository.deleteAllHistory();
    }


    public LiveData<ResponseDetail> detaill(String s) {
        detayo = searchRepository.getDetail(s);
        return detayo;
    }
    public void cleardetail() {
       detayo = null;
    }
//////////////////////
    public void insert(Favori favori){
        searchRepository.insertFavori(favori);
       //Toast.makeText(getApplication().getApplicationContext(), favori.word + " favorilerinize eklendi", Toast.LENGTH_SHORT).show();
    }
    public LiveData<List<Favori>> getfavlis(){
        favlist = searchRepository.getFavList();
        return favlist;
    }
    public LiveData<Favori> getFavoriLiveData(String word){
        favoriLiveData = searchRepository.getTek(word);
        return favoriLiveData;
    }
    public void update(Favori favori){
        searchRepository.update(favori);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("ffd","onCleared");
    }
}
