package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieList;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;

import java.util.List;

import retrofit2.Call;

public class MovieListModel implements IMovieList.Model {

    private MovieListRepository repository;

    public MovieListModel() {
        repository = new MovieListRepository();
    }

    @Override
    public Call<Movie> resultMovieList() {
        return repository.getList();
    }
}
