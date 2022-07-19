package com.info.omomom.catapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatApi {
    @GET("Europe/Istanbul")
    Call<RetrofitCat> getCat();
}
