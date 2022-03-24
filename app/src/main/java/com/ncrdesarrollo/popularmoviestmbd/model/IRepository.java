package com.ncrdesarrollo.popularmoviestmbd.model;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import java.util.List;

import retrofit2.Call;

public interface IRepository {

    interface ListMovie{
        Call<Movie> getList();
    }

    interface detailMovie{
        Call<Results> detailMovie();
    }

}
