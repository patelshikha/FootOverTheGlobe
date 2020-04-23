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
 * Created by shikh on 17-09-2017.
 */


public class HotelActivity2 extends Activity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private Context context;
    Hotel_Adapter2 adapter1;
    List<Hotel_Model2> List = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_listing);

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        int position = -1;

        if (getIntent() != null && getIntent().hasExtra("position")) {
            position=  getIntent().getIntExtra("position", -1);
        }

        RecyclerView rrv = (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rrv.setLayoutManager(mLayoutManager);
        rrv.setItemAnimator(new DefaultItemAnimator());
        Data();
        adapter1 = new Hotel_Adapter2(HotelActivity2.this, List, position);
        rrv.setAdapter(adapter1);


    }

    void Data() {

        List.add(new Hotel_Model2("Hotel Surya", R.drawable.o));
        List.add(new Hotel_Model2("Riya Revti", R.drawable.l));
        List.add(new Hotel_Model2("Ginger", R.drawable.o));
        List.add(new Hotel_Model2("Hotel Taj", R.drawable.l));
        List.add(new Hotel_Model2("Welcome", R.drawable.o));


    }
}










