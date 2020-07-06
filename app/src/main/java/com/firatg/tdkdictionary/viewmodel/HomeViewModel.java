package com.firatg.tdkdictionary.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.firatg.tdkdictionary.model.homepage.KaristirmaItem;
import com.firatg.tdkdictionary.model.homepage.KuralItem;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;
import com.firatg.tdkdictionary.model.homepage.Url;
import com.firatg.tdkdictionary.repository.HomePageRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private HomePageRepository homePageRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        homePageRepository = new HomePageRepository();
    }

    public LiveData<ResponseHome> getAnasayifa() {
        return homePageRepository.getAnasayfaIcerik();
    }

    public LiveData<List<KaristirmaItem>> getKarsilastirmaList(){
        return homePageRepository.getKarsilastirmaLis();
    }




}
