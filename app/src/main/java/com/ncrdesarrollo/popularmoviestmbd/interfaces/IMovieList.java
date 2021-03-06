package com.ncrdesarrollo.popularmoviestmbd.interfaces;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;

import java.util.List;

import retrofit2.Call;

public interface IMovieList {

    interface View{
        void updateData(Movie movie);
        void showMesage(String str);
        void showProgress();
        void hideProgress();
        void showBtnReinit();
        void hideBtnReinit();
    }

    interface Presenter{
        void loadData();
        void setView(IMovieList.View view);
        void onDestroy();
    }

    interface Model{
        Call<Movie> resultMovieList();
    }

}
