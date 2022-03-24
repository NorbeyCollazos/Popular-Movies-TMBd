package com.ncrdesarrollo.popularmoviestmbd.model.http;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {

    @GET("movie/popular?api_key=ea0b061bc609cf004a8c467e95c24ce1&language=es-ES")
    Call<Movie> getListMovies();

    @GET("")
    Call<Results> getDetail(@Query("id") Integer id);
}
