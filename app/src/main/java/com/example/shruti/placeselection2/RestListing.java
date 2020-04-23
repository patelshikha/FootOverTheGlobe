
package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class RestListing extends Activity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private Context context;
    Rest_CustomAdapter adapter1;
    List<Rest_Model> List = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_listing);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        int position = -1;

        if (getIntent() != null && getIntent().hasExtra("position")) {
            position=  getIntent().getIntExtra("position", -1);
        }

        RecyclerView rrv= (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rrv.setLayoutManager(mLayoutManager);
        rrv.setItemAnimator(new DefaultItemAnimator());
        Data();
        adapter1=new Rest_CustomAdapter(RestListing.this,List,position);
        rrv.setAdapter(adapter1);



    }
    void Data() {

        List.add(new Rest_Model("Little Italy", R.drawable.r1));
        List.add(new Rest_Model("Sizzling Salasa", R.drawable.r2));
        List.add(new Rest_Model("Rajwadu", R.drawable.r3));
        List.add(new Rest_Model("Grand Thakar", R.drawable.r4));
        List.add(new Rest_Model("Jassi Da Parathe", R.drawable.r1));



    }
}











