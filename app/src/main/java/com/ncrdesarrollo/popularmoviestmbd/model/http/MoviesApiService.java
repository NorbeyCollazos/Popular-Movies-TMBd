package com.ncrdesarrollo.popularmoviestmbd.model.http;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApiService {

    @GET("movie/popular?api_key=ea0b061bc609cf004a8c467e95c24ce1&language=es-ES")
    Call<Movie> getListMovies();

    @GET("movie/{movie_id}?api_key=ea0b061bc609cf004a8c467e95c24ce1&language=es-ES")
    Call<Results> getDetail(@Path("movie_id") String movie_id);
}
