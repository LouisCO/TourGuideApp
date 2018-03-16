package com.example.android.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detail_img)
    ImageView imageView;
    @BindView(R.id.category_name)
    TextView textView;
    @BindView(R.id.place_description)
    TextView textView1;
    @BindView(R.id.place_name)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home=new Intent(DetailActivity.this, MainActivity.class);
                startActivity(home);
            }
        });

        // Get the Intent from Fragment, extract and set the data
        Intent detail=getIntent();
        String placeName=detail.getStringExtra("place_name");
        String placeDescription=detail.getStringExtra("place_description");
        int placeImage=detail.getIntExtra("place_image", 0);
        String detailCategory=detail.getStringExtra("category");

        textView.setText(detailCategory);
        textView1.setText(placeDescription);
        textView2.setText(placeName);
        imageView.setImageResource(placeImage);
    }

    // Set onClick events using Butterknife
    @OnClick({R.id.address_img, R.id.address})
    void OnClickMap() {
        // Open location on map
        Intent mapIntent=new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:0,0?q=" + getString(R.string.latitude) + ","
                + getString(R.string.longitude)));
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @OnClick({R.id.phone_img, R.id.phone})
    void OnClickPhone() {
        // Open dialer with the phone no.
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getString(R.string.here_comes_phone_no)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @OnClick({R.id.web_img, R.id.web})
    void OnClickWeb() {
        // Open the website in the browser
        Uri webpage=Uri.parse("http://" + getString(R.string.web));
        Intent intentW=new Intent(Intent.ACTION_VIEW, webpage);
        if (intentW.resolveActivity(getPackageManager()) != null) {
            startActivity(intentW);
        }
    }
}
