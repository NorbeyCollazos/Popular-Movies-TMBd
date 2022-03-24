package com.ncrdesarrollo.popularmoviestmbd.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ncrdesarrollo.popularmoviestmbd.R;
import com.ncrdesarrollo.popularmoviestmbd.model.pojo.Movie;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.viewHolder> implements View.OnClickListener{

    private List<Movie> movieList;
    private View.OnClickListener listener;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        view.setOnClickListener(this);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Movie movie = movieList.get(position);
        Log.i("TAG2", movie.getResults().get(position).getTitle());
        Glide.with(holder.imageView.getContext())
                .load("https://image.tmdb.org/t/p/w500"+movie.getResults().get(position).getPoster_path())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        View view;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            view = itemView;

        }
    }
}
