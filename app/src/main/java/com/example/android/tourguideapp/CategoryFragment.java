package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    private static String CATEGORY_NAME="CATEGORY NAME";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public static CategoryFragment newInstance(String category) {
        Bundle ctg=new Bundle();
        ctg.putString(CATEGORY_NAME, category);
        CategoryFragment categoryFragment=new CategoryFragment();
        categoryFragment.setArguments(ctg);
        return categoryFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final ArrayList<Places> places=PlacesInput.getPlaces(getActivity(),
                getArguments().getString(CATEGORY_NAME));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PlacesAdapter(places));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                        // Create a new intent to open the {@link DetailActivity}
                        Intent detail=new Intent(getContext(), DetailActivity.class);
                        Places place=places.get(position);

                        // Pass location data
                        detail.putExtra("place_name", place.getName());
                        detail.putExtra("place_description", place.getDescription());
                        detail.putExtra("place_image", place.getImageResourceId());
                        detail.putExtra("category", getArguments().getString(CATEGORY_NAME));

                        // Start the new activity
                        startActivity(detail);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        // show message
                        Snackbar snackbar=Snackbar.make(view, "Should implement something someday :) " +
                                "here", Snackbar.LENGTH_LONG);
                        // Change action button text color
                        View sbView=snackbar.getView();
                        sbView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));
                        TextView textView=sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        snackbar.show();
                    }
                }));
    }
}
