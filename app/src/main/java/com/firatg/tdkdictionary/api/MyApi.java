package com.firatg.tdkdictionary.api;

import com.firatg.tdkdictionary.model.detail.ResponseDetail;
import com.firatg.tdkdictionary.model.homepage.ResponseHome;
import com.firatg.tdkdictionary.model.search.Suggestion;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    @GET("icerik")
    Call<ResponseHome> anasayfaVeriler();

    @GET("autocomplete.json")
    Call<List<Suggestion>>  autocompletelist();

    @GET("gts")
    Call<List<ResponseDetail>> getDetail(@Query("ara") String word);

}
