package com.eray.dgcinema.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;


import com.eray.dgcinema.fragments.BookmarkFragment;
import com.eray.dgcinema.fragments.HomeFragment;
import com.eray.dgcinema.model.Movies;
import com.eray.dgcinema.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private BookmarkFragment bookmarkFragment = new BookmarkFragment();
    private HomeFragment homeFragment = new HomeFragment();


    private static String JSON_URL = "https://api.themoviedb.org/3/movie/popular?api_key=f2b2065043e9ffe36d13d227205c1426";

    private ArrayList<Movies> movieList;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnavigation);

        fragmentexecute();
        movieList = new ArrayList<>();

        GetData getData = new GetData();
        getData.execute();
    }

    private void fragmentexecute() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment ).commit();
                        GetData getData = new GetData();
                        getData.execute();
                        return true;
                    case R.id.shopping_card:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, bookmarkFragment).commit();
                        return true;
                }


                return false;
            }
        });
    }


    private class GetData extends AsyncTask<String,String ,String> {



        @Override
        protected String doInBackground(String... strings) {

            String current = "";


            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1){
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (urlConnection == null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }
        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0 ; i < jsonArray.length() ; i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    Movies movies = new Movies();
                    movies.setVote_average(jsonObject1.getDouble("vote_average"));
                    movies.setPoster_path(jsonObject1.getString("poster_path"));
                    movies.setOriginal_title(jsonObject1.getString("original_title"));
                    movies.setOverview(jsonObject1.getString("original_title"));

                    movieList.add(movies);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            homeFragment.putDataIntoRecyclerView(movieList);
        }


    }



}