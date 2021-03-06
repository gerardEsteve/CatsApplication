package com.e.catsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    TextView nameText;
    TextView descText;
    TextView tempText;
    TextView wikiText;
    TextView countryText;
    ImageView imageView;
    String name,image,description,country,country_code,temperament,wiki_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        startUI();
        Intent prevIntent = getIntent();
        name = prevIntent.getStringExtra("name");
        image = prevIntent.getStringExtra("image_url");
        description = prevIntent.getStringExtra("description");
        country = prevIntent.getStringExtra("country");
        country_code = prevIntent.getStringExtra("country_code");
        temperament = prevIntent.getStringExtra("temperament");
        wiki_link = prevIntent.getStringExtra("wiki_link");

        setValues();

    }


    private void startUI() {
        nameText = findViewById(R.id.name_text2);
        descText = findViewById(R.id.description_text);
        tempText = findViewById(R.id.temperament_text);
        countryText = findViewById(R.id.country_text);
        wikiText = findViewById(R.id.wiki_text);
        imageView = findViewById(R.id.image_cat2);
    }

    private void setValues() {
        nameText.setText(name);
        descText.setText(description);
        tempText.setText(temperament);

        String country_info = country +" (" + country_code + ")";
        countryText.setText(country_info);

        if(!wiki_link.isEmpty())
            wikiText.setText(wiki_link);
        if (image.contains("http"))
            Picasso.with(this).load(image).into(imageView);
        else {
            OkHttpHandlerURL okHttpHandlerURL= new OkHttpHandlerURL(image,this,this);
            okHttpHandlerURL.execute();
        }

    }
}
