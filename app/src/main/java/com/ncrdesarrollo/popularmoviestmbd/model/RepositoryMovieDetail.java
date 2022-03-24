package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.model.http.MoviesApiService;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryMovieDetail implements IRepository.detailMovie{

    private String idMovie;

    private String BASE_URL = "https://api.themoviedb.org/3/";

    public RepositoryMovieDetail(String idMovie) {
        this.idMovie = idMovie;
    }

    OkHttpClient client = new OkHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    MoviesApiService apiService = retrofit.create(MoviesApiService.class);


    @Override
    public Call<Results> detailMovie() {
        Call<Results> call = apiService.getDetail(idMovie);
        return call;
    }
}
