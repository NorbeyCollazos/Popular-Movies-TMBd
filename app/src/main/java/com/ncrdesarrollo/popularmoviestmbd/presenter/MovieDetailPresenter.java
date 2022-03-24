package com.ncrdesarrollo.popularmoviestmbd.presenter;

import android.util.Log;

import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieDetail;
import com.ncrdesarrollo.popularmoviestmbd.model.MovieDetailModel;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailPresenter implements IMovieDetail.Presenter {

    private String idMovie;
    private IMovieDetail.View view;
    private IMovieDetail.Model model;

    public MovieDetailPresenter(String idMovie) {
        this.idMovie = idMovie;
        model = new MovieDetailModel(idMovie);
    }

    @Override
    public void loadData() {
        view.hideBtnReinit();
        view.showProgress();
        model.resultMovieData().enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    Results results = response.body();
                    Log.i("DATA", results.getTitle());
                    view.dataDetailMovie(results);
                }else{
                    view.showMesage("error");
                    view.showBtnReinit();
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                view.hideProgress();
                Log.i("DATAERROR", t.getMessage());
                view.showMesage("Ocurrio un error");
                view.showBtnReinit();
            }
        });
    }

    @Override
    public void setView(IMovieDetail.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
