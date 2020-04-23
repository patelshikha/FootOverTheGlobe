package com.example.shruti.placeselection2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Date_MainActivity extends AppCompatActivity {
    private static final String TAG="Date_MainActivity";
    private TextView mDisplayDate1,mDisplayDate2;



    private DatePickerDialog.OnDateSetListener mDateSetListner1;
    private DatePickerDialog.OnDateSetListener mDateSetListner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity_main);
        mDisplayDate1=(TextView)findViewById(R.id.textView9);
        mDisplayDate2=(TextView)findViewById(R.id.textView3);


        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(Date_MainActivity.this,
                        PlaceSelectionMain.class);
                startActivity(myIntent);
            }
        });


        mDisplayDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(
                        Date_MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListner1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDisplayDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(
                        Date_MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListner2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListner1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: mm/dd/yyyy"+month+"/"+day+"/"+year);
                String date=month +"/"+ day+"/"+year;
                mDisplayDate1.setText(date);

            }
        };
        mDateSetListner2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: mm/dd/yyyy"+month+"/"+day+"/"+year);
                String date=month +"/"+ day+"/"+year;

                mDisplayDate2.setText(date);
            }
        };

    }
}
