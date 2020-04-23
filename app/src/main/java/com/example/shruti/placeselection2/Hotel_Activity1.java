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

public class Hotel_Activity1 extends Activity {

    List<Hotel_Model1> List = new ArrayList<>();
    Context context;
    RecyclerView rvPlaces;
    Button bres;
    Hotel_Adapter1 hotelAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity_main);
        bres = (Button) findViewById(R.id.bres);
        rvPlaces = (RecyclerView) findViewById(R.id.rvPlaces);
      bres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(Hotel_Activity1.this, Rest_MainActivity.class);
                startActivity(myIntent);
            }
        });


        List.add(new Hotel_Model1("13-11-2017", null));
        List.add(new Hotel_Model1("14-11-2017", null));
        List.add(new Hotel_Model1("15-11-2017", null));
        List.add(new Hotel_Model1("16-11-2017", null));
        List.add(new Hotel_Model1("17-11-2017", null));


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPlaces.setLayoutManager(mLayoutManager);

        hotelAdapter = new Hotel_Adapter1(Hotel_Activity1.this, List);
        rvPlaces.setAdapter(hotelAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                int pos = data.getIntExtra("position", -1);
                if (pos != -1) {
                    List.get(pos).setObjHotel((Hotel_Model2) data.getParcelableExtra("hotel"));


                    if (hotelAdapter != null) {
                        hotelAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}