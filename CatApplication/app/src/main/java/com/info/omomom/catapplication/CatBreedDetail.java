package com.info.omomom.catapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CatBreedDetail extends AppCompatActivity {

    private TextView textViewCatName,textViewCatDetails;
    private ImageView imageViewBack,imageViewStarDetail,imageViewCatDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_breed_detail);

        textViewCatName=findViewById(R.id.textViewCatName);
        textViewCatDetails=findViewById(R.id.textViewCatDetails);
        imageViewBack=findViewById(R.id.imageViewBack);
        imageViewStarDetail=findViewById(R.id.imageViewStarDetail);
        imageViewCatDetail=findViewById(R.id.imageViewCatDetail);
    }
}