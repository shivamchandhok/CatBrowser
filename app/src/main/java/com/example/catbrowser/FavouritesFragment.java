package com.example.catbrowser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    private RecyclerView recyclerView;
    ArrayList<CatPhotos> objectList1=CatDetailActivity.list1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.favourites, container, false);
        recyclerView = view.findViewById(R.id.fav_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FavouritesAdapter favouritesAdapter = new FavouritesAdapter();
        favouritesAdapter.setData(objectList1);
        recyclerView.setAdapter(favouritesAdapter);


        return view;
    }


}
