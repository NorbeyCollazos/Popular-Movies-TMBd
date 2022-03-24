package com.ncrdesarrollo.popularmoviestmbd.interfaces;

import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;

import retrofit2.Call;

public interface IMovieDetail {

    interface View{
        void dataDetailMovie(Results results);
        void showMesage(String str);
        void showProgress();
        void hideProgress();
        void showBtnReinit();
        void hideBtnReinit();
    }

    interface Presenter{
        void loadData();
        void setView(IMovieDetail.View view);
        void onDestroy();
    }

    interface Model{
        Call<Results> resultMovieData();
    }

}
