package com.ncrdesarrollo.popularmoviestmbd.model.http;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesApiService {

    @GET("movie/popular")
    Call<Movie> getListMovies(@Query("api_key") String api_key, @Query("language") String languaje );

    @GET("movie/{movie_id}")
    Call<Results> getDetail(@Path("movie_id") String movie_id, @Query("api_key") String api_key, @Query("language") String languaje );
}
