package com.ncrdesarrollo.popularmoviestmbd.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncrdesarrollo.popularmoviestmbd.R;
import com.ncrdesarrollo.popularmoviestmbd.databinding.FragmentMovieDetailBinding;
import com.ncrdesarrollo.popularmoviestmbd.databinding.FragmentMoviesListBinding;

public class MoviesListFragment extends Fragment {

    private FragmentMoviesListBinding binding;

    public MoviesListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMoviesListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}