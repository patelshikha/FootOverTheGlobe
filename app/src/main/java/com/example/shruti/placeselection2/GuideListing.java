package com.example.shruti.placeselection2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinal mayavanshi on 08-12-2017.
 */

public class GuideListing extends Activity {

    Spinner spinner;
    ArrayAdapter<String> adapter;
    private Context context;
    Guide_CustomAdapter adapter1;
    List<Guide_Model> defGuideList = new ArrayList<>();
    List<Guide_Model> tempGuideList = new ArrayList<>();
    ArrayList<Languages> languageList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_listing);

        spinner = (Spinner) findViewById(R.id.spinner);


        final ArrayList<Languages> languageList = new ArrayList<>();
        languageList.add(new Languages(1, "All"));
        languageList.add(new Languages(2, "Hindi"));
        languageList.add(new Languages(3, "Gujarati"));
        languageList.add(new Languages(4, "Marathi"));
        languageList.add(new Languages(5, "English"));

        String[] frnames = new String[languageList.size()];

        for (int i = 0; i < languageList.size(); i++) {
            frnames[i] = languageList.get(i).getLangname();
        }


        adapter = new ArrayAdapter<String>(GuideListing.this, android.R.layout.simple_spinner_item, frnames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        int position = -1;

        if (getIntent() != null && getIntent().hasExtra("position")) {
            position = getIntent().getIntExtra("position", -1);
        }



/*

       spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                String selectedItem=parent.getItemAtPosition(position).toString();
                Toast toastSpinnerSelection= Toast.makeText(getApplicationContext(),selectedItem,Toast.LENGTH_SHORT);

                toastSpinnerSelection.setGravity(Gravity.LEFT|Gravity.BOTTOM,20,150);
                toastSpinnerSelection.show();
            }
        });
*/


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                //Log.d("Error", "onItemSelected: " + pos);

                tempGuideList.clear();

                if (pos == 0) {
                    tempGuideList.addAll(defGuideList);
                } else {
                    for (int i = 0; i < defGuideList.size(); i++) {
                        Log.d("Error", "onItemSelected: id: " + languageList.get(pos).getLangId()
                                + " pos: " + pos + " id: " + defGuideList.get(i).getLangId());

                        if (languageList.get(pos).getLangId() == defGuideList.get(i).getLangId()) {
                            tempGuideList.add(defGuideList.get(i));
                        }


                    }
                }

                adapter1.notifyDataSetChanged();

                if (tempGuideList.size() == 0) {
                    Toast.makeText(GuideListing.this, "No guide available for " + languageList.get(pos).getLangname() + " language.", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }


        });

        RecyclerView rrv = (RecyclerView) findViewById(R.id.rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rrv.setLayoutManager(mLayoutManager);
        rrv.setItemAnimator(new DefaultItemAnimator());
        Data();

        tempGuideList.addAll(defGuideList);

        adapter1 = new Guide_CustomAdapter(GuideListing.this, tempGuideList, position);
        rrv.setAdapter(adapter1);

    }


    void Data() {

        defGuideList.add(new Guide_Model("Guide1", R.drawable.profile, 1));
        defGuideList.add(new Guide_Model("Guide2", R.drawable.profile, 1));
        defGuideList.add(new Guide_Model("Guide3", R.drawable.profile, 2));
        defGuideList.add(new Guide_Model("Guide4", R.drawable.profile, 2));
        defGuideList.add(new Guide_Model("Guide5", R.drawable.profile, 3));


    }
}



