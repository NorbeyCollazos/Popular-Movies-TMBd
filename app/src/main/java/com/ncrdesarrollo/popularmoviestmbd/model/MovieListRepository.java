package com.ncrdesarrollo.popularmoviestmbd.model;

import android.util.Log;

import com.ncrdesarrollo.popularmoviestmbd.model.http.MoviesApiService;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieListRepository implements Repository {

    private String BASE_URL = "https://api.themoviedb.org/3/";
    private String API_KEY = "";


    OkHttpClient client = new OkHttpClient();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    MoviesApiService apiService = retrofit.create(MoviesApiService.class);


    @Override
    public Call<Movie> getList() {
        Log.i("TAG", "Hola");
        Call<Movie> call = apiService.getListMovies();
        return call;
    }

}
