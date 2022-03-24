package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieList;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;

import retrofit2.Call;

public class MovieListModel implements IMovieList.Model {

    private RepositoryMovieList repository;

    public MovieListModel() {
        repository = new RepositoryMovieList();
    }

    @Override
    public Call<Movie> resultMovieList() {
        return repository.getList();
    }
}
