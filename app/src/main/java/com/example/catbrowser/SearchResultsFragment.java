package com.example.catbrowser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;

public class SearchResultsFragment extends Fragment {

    SearchView searchView ;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.cat_search_page, container, false);
        searchView = view.findViewById(R.id.search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                Context context = getContext();
                CharSequence query1 = searchView.getQuery();
                Intent intent = new Intent(context, ResultsIntent.class);
                intent.putExtra("query_name", query);
                //System.out.println(query1);
                startActivity(intent);
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
// do something when text changes
                return false;
            }
        });

        return view;
}
}
