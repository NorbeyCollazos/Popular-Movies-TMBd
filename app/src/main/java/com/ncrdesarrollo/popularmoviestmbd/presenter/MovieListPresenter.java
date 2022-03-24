package com.ncrdesarrollo.popularmoviestmbd.presenter;

import android.util.Log;

import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieList;
import com.ncrdesarrollo.popularmoviestmbd.model.MovieListModel;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListPresenter implements IMovieList.Presenter {

    private IMovieList.View view;
    private MovieListModel model;

    public MovieListPresenter() {
        model = new MovieListModel();
    }

    @Override
    public void loadData() {
        view.hideBtnReinit();
        view.showProgress();
        model.resultMovieList().enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                view.hideProgress();
                if (response.isSuccessful()){
                    Movie movie = response.body();
                    for (int i = 0; i<movie.getResults().size(); i++){
                        Log.i("TAGLIST", movie.getResults().get(i).getTitle());
                        view.updateData(movie);
                    }
                }else {
                    view.showMesage("Ocurripo un error");
                    view.showBtnReinit();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.i("TAG", t.getMessage());
                view.showMesage("Ocurrió un error");
                view.hideProgress();
                view.showBtnReinit();
            }
        });
    }

    @Override
    public void setView(IMovieList.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }
}
