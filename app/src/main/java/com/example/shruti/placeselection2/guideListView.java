package com.example.shruti.placeselection2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by jinal mayavanshi on 28-12-2017.
 */

public class guideListView extends Activity {

    RecyclerView guideListView,rv1;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity_main);

        guideListView=(RecyclerView) findViewById(R.id.rvPlaces);


       //rv1.setAdapter(new ArrayAdapter<Languages>(this,android.R.layout.simple_list_item_1,adapter));
        rv1.setOnClickListener((View.OnClickListener) this);

    }
}