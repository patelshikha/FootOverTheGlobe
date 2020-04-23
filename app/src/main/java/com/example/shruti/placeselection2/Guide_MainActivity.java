package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Guide_MainActivity extends Activity {

    ArrayList<Guide_FeedItem> guideList = new ArrayList<>();
    ArrayList<Languages> languageList=new ArrayList<>();
    Context context;
    RecyclerView rvPlaces;
    Spinner spinner;
    guideListView lv1;
    ArrayAdapter<CharSequence> adapter;
    Guide_Adapter guideAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity_main);
        rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);


        guideList.add(new Guide_FeedItem("Vadodara",null));
        guideList.add(new Guide_FeedItem("Surat",null));
        guideList.add(new Guide_FeedItem("Ahmedabad",null));
        guideList.add(new Guide_FeedItem("Rajkot",null));


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPlaces.setLayoutManager(mLayoutManager);


        guideAdapter = new Guide_Adapter(Guide_MainActivity.this, guideList,languageList);
        rvPlaces.setAdapter(guideAdapter);





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                int pos = data.getIntExtra("position", -1);
                if (pos != -1) {
                    guideList.get(pos).setObjGuide((Guide_Model) data.getParcelableExtra("guide"));


                    if (guideAdapter != null) {
                        guideAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}


