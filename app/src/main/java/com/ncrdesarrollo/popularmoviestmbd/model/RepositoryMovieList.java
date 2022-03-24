package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.model.http.MoviesApiService;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryMovieList implements IRepository.ListMovie {

    private String BASE_URL = "https://api.themoviedb.org/3/";


    OkHttpClient client = new OkHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    MoviesApiService apiService = retrofit.create(MoviesApiService.class);


    @Override
    public Call<Movie> getList() {
        Call<Movie> call = apiService.getListMovies();
        return call;
    }



}
