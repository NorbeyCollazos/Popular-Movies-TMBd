package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieDetail;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import retrofit2.Call;

public class MovieDetailModel implements IMovieDetail.Model {

    private String idMovie;

    private RepositoryMovieDetail repository;

    public MovieDetailModel(String idMovie) {
        this.idMovie = idMovie;
        repository = new RepositoryMovieDetail(idMovie);
    }

    @Override
    public Call<Results> resultMovieData() {
        return repository.detailMovie();
    }
}
