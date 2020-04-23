package com.example.shruti.placeselection2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Car_MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_activity_main);

        RecyclerView rrv= (RecyclerView) findViewById(R.id.rv);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rrv.setLayoutManager(mLayoutManager);
        rrv.setItemAnimator(new DefaultItemAnimator());



        Car_MySQLiteHelper db = new Car_MySQLiteHelper(this);


        //db.addBook(new CAR("CAR1",R.drawable.cara,));
        //db.addBook(new CAR("CAR2",R.drawable.carb));
        //db.addBook(new CAR("CAR3",R.drawable.carcjpg));
        //db.addBook(new CAR("CAR4 ",R.drawable.cardjpg));




        List<CAR> list = new ArrayList<>();
        list.add(new CAR("VOLKSWAGON","Economy Car",R.drawable.cara, "4 seats|4 Doors","AC-FREE WIFI"));
        list.add(new CAR("AUDI","Economy Car",R.drawable.carb, "5 Seats|4 Doors","AC-FREE WIFI"));
        list.add(new CAR("BMW","Intermediate Car",R.drawable.carcjpg, "4 Seats|4 Doors","AC-FREE WIFI"));
        list.add(new CAR("HYUNDAI","Intermediate Car",R.drawable.carcjpg, "4 Seats|Doors","NON-AC"));

        if(list.size() > 0){
            rrv.setVisibility(View.VISIBLE);
            Car_Adapter mCarAdapter = new Car_Adapter(this,list);
            rrv.setAdapter(mCarAdapter);
        }else {
            rrv.setVisibility(View.GONE);
            Toast.makeText(this, " There is no data", Toast.LENGTH_LONG).show();
        }







    }
}
