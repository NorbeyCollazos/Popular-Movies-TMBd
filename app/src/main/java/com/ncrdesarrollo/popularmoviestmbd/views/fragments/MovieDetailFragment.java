package com.ncrdesarrollo.popularmoviestmbd.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ncrdesarrollo.popularmoviestmbd.R;
import com.ncrdesarrollo.popularmoviestmbd.databinding.FragmentMovieDetailBinding;
import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieDetail;
import com.ncrdesarrollo.popularmoviestmbd.model.http.Vars;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;
import com.ncrdesarrollo.popularmoviestmbd.presenter.MovieDetailPresenter;

public class MovieDetailFragment extends Fragment implements IMovieDetail.View {

    private FragmentMovieDetailBinding binding;
    private String idPelicula;

    private MovieDetailPresenter presenter;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idPelicula = getArguments().getString("id");

        presenter = new MovieDetailPresenter(idPelicula);


        binding.btnReinit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadData();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onDestroy();
    }

    @Override
    public void dataDetailMovie(Results results) {
        binding.tvTitle.setText(results.getTitle());
        binding.tvDescription.setText(results.getOverview());

        Glide.with(getContext())
                .load(Vars.URL_BASE_IMG+results.getPoster_path())
                .into(binding.image);
    }

    @Override
    public void showMesage(String str) {
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        binding.progressCircular.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progressCircular.setVisibility(View.GONE);
    }

    @Override
    public void showBtnReinit() {
        binding.btnReinit.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBtnReinit() {
        binding.btnReinit.setVisibility(View.GONE);
    }
}