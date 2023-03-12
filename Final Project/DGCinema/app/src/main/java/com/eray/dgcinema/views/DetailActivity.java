package com.eray.dgcinema.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eray.dgcinema.R;
import com.eray.dgcinema.adapters.MovieAdapter;
import com.eray.dgcinema.model.Movies;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
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

        Intent intent = getIntent();
        Movies selectedMovies = (Movies) intent.getSerializableExtra("movies");
        overview.setText(selectedMovies.getOverview());
        String url = "https://image.tmdb.org/t/p/w500" + selectedMovies.getPoster_path();
        Glide.with(this).load(url).into(poster);
        moiveName.setText(selectedMovies.getOriginal_title());
        language.setText(selectedMovies.getOriginal_language());
    }

}