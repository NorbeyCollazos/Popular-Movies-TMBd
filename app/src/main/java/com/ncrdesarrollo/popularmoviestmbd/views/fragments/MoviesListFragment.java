package com.ncrdesarrollo.popularmoviestmbd.views.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ncrdesarrollo.popularmoviestmbd.R;
import com.ncrdesarrollo.popularmoviestmbd.adapter.MovieAdapter;
import com.ncrdesarrollo.popularmoviestmbd.databinding.FragmentMoviesListBinding;
import com.ncrdesarrollo.popularmoviestmbd.interfaces.IMovieList;
import com.ncrdesarrollo.popularmoviestmbd.model.MovieListModel;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Results;
import com.ncrdesarrollo.popularmoviestmbd.presenter.MovieListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MoviesListFragment extends Fragment implements IMovieList.View {

    private FragmentMoviesListBinding binding;

    private MovieListPresenter presenter;

    private MovieAdapter adapter;
    private List<Movie> movieList = new ArrayList<>();

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

        presenter = new MovieListPresenter();

        presenter.setView(this);
        presenter.loadData();

        adapter = new MovieAdapter(movieList);
        binding.rvMoviesList.setAdapter(adapter);
        binding.rvMoviesList.setLayoutManager(new GridLayoutManager(getContext(), 3));

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = binding.rvMoviesList.getChildAdapterPosition(v);
                String id = movieList.get(position).getResults().get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Navigation.findNavController(view).navigate(R.id.movieDetailFragment, bundle);

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void updateData(Movie movie) {
        movieList.add(movie);
        adapter.notifyItemInserted(movieList.size()-1);
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
}