package com.firatg.tdkdictionary.repository;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;

import com.firatg.tdkdictionary.api.MyApi;
import com.firatg.tdkdictionary.api.MyClient;
import com.firatg.tdkdictionary.model.homepage.KaristirmaItem;
import com.firatg.tdkdictionary.model.homepage.KuralItem;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageRepository {
    public MutableLiveData<ResponseHome> anasayfaIcerik =new MutableLiveData<>();
    ResponseHome responseHomeModel;
    //karşılaştırma için iki tane list tipinde eleman
    private MutableLiveData<List<KaristirmaItem>> listkaristirmaItemMutableLiveData = new MutableLiveData<>();
    public List<KaristirmaItem> karistirmaItemList = new ArrayList<>();



    public HomePageRepository() {
    }

    public MutableLiveData<ResponseHome> getAnasayfaIcerik() {
        MyApi api = MyClient.getInstance().getMyApi();
        Call<ResponseHome> call = api.anasayfaVeriler();
        call.enqueue(new Callback<ResponseHome>() {
            @Override
            public void onResponse(Call<ResponseHome> call, Response<ResponseHome> response) {
                responseHomeModel=response.body();
                anasayfaIcerik.setValue(responseHomeModel);
                //anasayfadaki karşılaştırma kartlari için
                karistirmaItemList = response.body().getKaristirma();
                if (karistirmaItemList != null) {
                    listkaristirmaItemMutableLiveData.setValue(karistirmaItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseHome> call, Throwable t) {

            }
        });
        return anasayfaIcerik;
    }

    //anasayfadaki verileri tek seferde cektiğim için burada network işlemi yok sadece listeyi dönderdim.
    public MutableLiveData<List<KaristirmaItem>> getKarsilastirmaLis(){
        return listkaristirmaItemMutableLiveData;
    }






}
