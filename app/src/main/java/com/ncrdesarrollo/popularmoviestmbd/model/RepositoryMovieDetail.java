package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.model.http.MoviesApiService;
import com.ncrdesarrollo.popularmoviestmbd.model.http.RetrofitInstance;
import com.ncrdesarrollo.popularmoviestmbd.model.http.Vars;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import retrofit2.Call;

public class RepositoryMovieDetail implements IRepository.detailMovie{

    private String idMovie;
    private MoviesApiService apiService;


    public RepositoryMovieDetail(String idMovie) {
        this.idMovie = idMovie;
        apiService = RetrofitInstance.getApiService();
    }


    @Override
    public Call<Results> detailMovie() {
        Call<Results> call = apiService.getDetail(idMovie, Vars.API_KEY, Vars.LANGUAJE);
        return call;
    }
}
