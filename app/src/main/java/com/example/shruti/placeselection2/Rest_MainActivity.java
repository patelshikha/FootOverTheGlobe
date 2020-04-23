package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Rest_MainActivity extends Activity {

    List<Rest_FeedItem> List = new ArrayList<>();
    Context context;
    RecyclerView rvPlaces;
    Button bguide;
    Rest_Adapter restAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_activity_main);
        bguide=(Button) findViewById(R.id.bguide);
        rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);
        bguide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(Rest_MainActivity.this, Guide_MainActivity.class);
                startActivity(myIntent);
            }
        });


        List.add(new Rest_FeedItem("13-11-2017", null));
        List.add(new Rest_FeedItem("14-11-2017", null));
        List.add(new Rest_FeedItem("15-11-2017", null));
        List.add(new Rest_FeedItem("16-11-2017", null));
        List.add(new Rest_FeedItem("17-11-2017", null));


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPlaces.setLayoutManager(mLayoutManager);

        restAdapter = new Rest_Adapter(Rest_MainActivity.this, List);
        rvPlaces.setAdapter(restAdapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                int pos = data.getIntExtra("position", -1);
                if (pos != -1) {


                    List.get(pos).setObjRest((Rest_Model) data.getParcelableExtra("restaurant"));


                    if (restAdapter != null) {
                        restAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

}