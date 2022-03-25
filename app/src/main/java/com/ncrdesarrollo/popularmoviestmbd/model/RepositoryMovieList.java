package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.model.http.MoviesApiService;
import com.ncrdesarrollo.popularmoviestmbd.model.http.RetrofitInstance;
import com.ncrdesarrollo.popularmoviestmbd.model.http.Vars;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryMovieList implements IRepository.ListMovie {

    private MoviesApiService apiService;

    public RepositoryMovieList() {
        apiService = RetrofitInstance.getApiService();
    }

    @Override
    public Call<Movie> getList() {
        Call<Movie> call = apiService.getListMovies(Vars.API_KEY, Vars.LANGUAJE);
        return call;
    }



}
