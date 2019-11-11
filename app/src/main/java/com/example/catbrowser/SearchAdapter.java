package com.example.catbrowser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.searchViewHolder>{

    public List<Breeds> breedsToAdapt;

    public void setData(List<Breeds> breedsToAdapt) {
        // This is basically a Setter that we use to give data to the adapter
        this.breedsToAdapt = breedsToAdapt;
    }

    @NonNull
    @Override
    public SearchAdapter.searchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat_result_page, parent, false);
        searchViewHolder searchViewHolder = new searchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.searchViewHolder holder, final int position) {
        final Breeds breedsatposition = breedsToAdapt.get(position);
        //  System.out.println(breedsToAdapt.);
        holder.textView.setText(breedsatposition.getName());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, CatDetailActivity.class);
                intent.putExtra("breedsid", breedsToAdapt.get(position).getId());
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return  breedsToAdapt.size();
    }


    public static  class searchViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView textView;
        public ConstraintLayout constraintLayout;

        public searchViewHolder(@NonNull View v) {
            super(v);
            view = v;
            textView = v.findViewById(R.id.catName);
            constraintLayout = v.findViewById(R.id.cl_results);
        }
    }


}
