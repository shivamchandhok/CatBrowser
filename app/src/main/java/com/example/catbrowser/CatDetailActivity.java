package com.example.catbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatDetailActivity extends AppCompatActivity {

    public static ArrayList<CatPhotos> list1 = new ArrayList<>();
    //public static ArrayList<Catimage> objectList;
    public static ArrayList<CatPhotos> newlist = new ArrayList<>();
    private TextView name;
    private TextView description;
    private TextView temp;
    private TextView life;
    private TextView wikiurl;
    private TextView weightImperical;
    private TextView weightMetric;
    private TextView friendless;
    private TextView origin;
    private ImageView catpic;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);

        name = findViewById(R.id.catDetailName);
        description = findViewById(R.id.catDetailDescrp);
        temp = findViewById(R.id.catTemp);
        life = findViewById(R.id.catLife);
        wikiurl = findViewById(R.id.catWiki);
        weightImperical = findViewById(R.id.catWeight);
        weightMetric = findViewById(R.id.catMetricWeight);
        friendless = findViewById(R.id.catFriendly);
        origin = findViewById(R.id.catOrigin);
        catpic = findViewById(R.id.catDetailPic);
        button = findViewById(R.id.favBt);

        Intent intent = getIntent();
        final String breedsid = intent.getStringExtra("breedsid");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + breedsid;
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);

                Gson gson = new Gson();
                CatPhotos[] enums = gson.fromJson(response, CatPhotos[].class);
                final List<CatPhotos> objectList = Arrays.asList(enums);
                String imageUrl = objectList.get(0).getUrl();
                Glide.with(getApplicationContext()).load(imageUrl).into(catpic);
                System.out.println(objectList.get(0).getBreeds().get(0).getResult().getImperial());


                weightImperical.setText(objectList.get(0).getBreeds().get(0).getResult().getImperial());
////
                weightMetric.setText(objectList.get(0).getBreeds().get(0).getResult().getMetric());

                name.setText(objectList.get(0).getBreeds().get(0).getName());

                temp.setText(objectList.get(0).getBreeds().get(0).getTemperament());

                life.setText(objectList.get(0).getBreeds().get(0).getLife_span());

                wikiurl.setText(objectList.get(0).getBreeds().get(0).getWikipedia_url());

                description.setText(objectList.get(0).getBreeds().get(0).getDescription());

                origin.setText(objectList.get(0).getBreeds().get(0).getOrigin());

                friendless.setText(String.valueOf(objectList.get(0).getBreeds().get(0).getDog_friendly()));


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Context context = v.getContext();
                        //Intent intent = new Intent(context, MainActivity.class);
                        list1.add((objectList.get(0)));
                        Toast.makeText(getApplicationContext(), "Cat added to Favourites!", Toast.LENGTH_SHORT).show();

                        System.out.println(list1.size());
                        // context.startActivity(intent);

                    }
                });
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText("The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        requestQueue.add(stringRequest);
    }
}