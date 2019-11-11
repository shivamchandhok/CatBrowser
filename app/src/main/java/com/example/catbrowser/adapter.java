package com.example.catbrowser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.adapterViewHolder> {

    private List<Breeds> breedsList;

    public void setData(List<Breeds> breedsList) {
        this.breedsList = breedsList;
    }

    @NonNull
    @Override
    public adapter.adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat_result_page, parent, false);

        adapterViewHolder breedsViewHolder = new adapterViewHolder(view);
        return breedsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.adapterViewHolder holder, int position) {

        final Breeds breeds = breedsList.get(position);
        //System.out.println(breedsList.toArray());
        holder.name.setText(breeds.getName());
        holder.temperament.setText(breeds.getTemperament());
        holder.life_span.setText(breeds.getLife_span());
        holder.wikipedia_url.setText(breeds.getWikipedia_url());

    }

    @Override
    public int getItemCount() {
        return breedsList.size();
    }

    public static class adapterViewHolder extends RecyclerView.ViewHolder  {
        public TextView name;
        public View view;
        public TextView temperament;
        public TextView life_span;
        public TextView wikipedia_url;
        public adapterViewHolder(@NonNull View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.catName);
            temperament = v.findViewById(R.id.catTemp);
            life_span = v.findViewById(R.id.catLife);
            wikipedia_url = v.findViewById(R.id.catWiki);

        }
        public void bind(final Breeds breeds){

            name.setText(breeds.getName());
            temperament.setText(breeds.getTemperament());
            life_span.setText(breeds.getLife_span());
            wikipedia_url.setText(breeds.getWikipedia_url());


        }

}
}
