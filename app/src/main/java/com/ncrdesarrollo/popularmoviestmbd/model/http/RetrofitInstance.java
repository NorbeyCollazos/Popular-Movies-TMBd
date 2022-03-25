package com.ncrdesarrollo.popularmoviestmbd.model.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static MoviesApiService getApiService(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Vars.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MoviesApiService.class);
    }
}
