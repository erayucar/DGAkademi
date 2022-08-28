package com.eray.dgcinema.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eray.dgcinema.R;
import com.eray.dgcinema.adapters.MovieAdapter;
import com.eray.dgcinema.model.Movies;
import com.eray.dgcinema.views.DetailActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements MovieAdapter.ItemClikListener {
    private ArrayList<Movies> list;
    private MovieAdapter adapter;
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.movies_recyc);

        return view;
    }
    public void putDataIntoRecyclerView(ArrayList<Movies> movieList) {
        this.list = movieList;
        this.adapter = new MovieAdapter(this.getContext(), list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onItemClick(Movies movies) {

    }

    @Override
    public void recyItemClick(List<Movies> moviesList, int position) {

    }


}