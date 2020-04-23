package com.example.shruti.placeselection2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Place_page3 extends AppCompatActivity {
    TextView name,dec;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_page3);

        name=(TextView) findViewById(R.id.name1);
        imgview=(ImageView) findViewById(R.id.imgview1);
        dec=(TextView) findViewById(R.id.dec1);

        Intent i=this.getIntent();
        String n=i.getExtras().getString("NAME_KEY");
        int img=i.getExtras().getInt("IMAGE_KEY");
        String decr=i.getExtras().getString("DEC_KEY");

        name.setText(n);
        dec.setText(decr);
        imgview.setImageResource(img);
    }
}