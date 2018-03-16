package com.example.android.tourguideapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  Created by Lenovo on 13/03/2018.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    private ArrayList<Places> places;

    PlacesAdapter(ArrayList<Places> places) {
        this.places=places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Places place=this.places.get(position);
        holder.name.setText(place.getName());
        holder.description.setText(place.getDescription());
        holder.image.setImageResource(place.getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return this.places.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.place_image)
        ImageView image;
        @BindView(R.id.place_name)
        TextView name;
        @BindView(R.id.place_description)
        TextView description;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
