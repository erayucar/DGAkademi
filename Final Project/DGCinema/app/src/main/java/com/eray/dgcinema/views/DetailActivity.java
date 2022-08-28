package com.eray.dgcinema.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eray.dgcinema.R;
import com.eray.dgcinema.adapters.MovieAdapter;
import com.eray.dgcinema.model.Movies;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements MovieAdapter.ItemClikListener {
    private TextView overview;
    private TextView voteAvr;
    private TextView moiveName;
    private TextView language;
    private ImageView poster;
    private List<Movies> moviesList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        overview = findViewById(R.id.overview);
        voteAvr = findViewById(R.id.vote_avr);
        moiveName = findViewById(R.id.movie_name);
        language = findViewById(R.id.language);
        poster = findViewById(R.id.image_poster);
    }

    @Override
    public void onItemClick(Movies movies) {

    }

    @Override
    public void recyItemClick(List<Movies> moviesList, int position) {
        this.moviesList = moviesList;
        moiveName.setText(moviesList.get(position).getOriginal_title());
        overview.setText(moviesList.get(position).getOverview());
        String url = "https://image.tmdb.org/t/p/w500" + moviesList.get(position).getPoster_path();
        Glide.with(this).load(url).into(poster);
        voteAvr.setText( String.valueOf(moviesList.get(position).getVote_average()));
    }
}