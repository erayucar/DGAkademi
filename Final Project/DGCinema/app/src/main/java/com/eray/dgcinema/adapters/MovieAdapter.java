package com.eray.dgcinema.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eray.dgcinema.model.Movies;
import com.eray.dgcinema.R;
import com.eray.dgcinema.views.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Movies> moviesList;

    private SharedPreferences sharedPreferences;

    public MovieAdapter(Context context, ArrayList<Movies> movies ){
        this.moviesList = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos = position;
        String url = "https://image.tmdb.org/t/p/w500" + moviesList.get(position).getPoster_path();
        Glide.with(context).load(url).into(holder.imageView);
        holder.name.setText(moviesList.get(position).getOriginal_title());
        holder.vote_avr.setText(String.valueOf(moviesList.get(position).getVote_average()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("movies",moviesList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

            return moviesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView name, vote_avr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_movies);
            name = itemView.findViewById(R.id.movie_name);
            vote_avr = itemView.findViewById(R.id.rate_imdb);
        }
    }

}
