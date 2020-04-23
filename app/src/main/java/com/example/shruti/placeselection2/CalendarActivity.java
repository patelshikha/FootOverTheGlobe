package com.example.shruti.placeselection2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.savvi.rangedatepicker.CalendarPickerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    CalendarPickerView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        Date currentDate = new Date(System.currentTimeMillis());

        Calendar myCal = Calendar.getInstance();
        myCal.add(Calendar.YEAR, 1);

        calendar.init(currentDate, myCal.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.RANGE) //
                .withSelectedDate(new Date());

        // This line is IMPORTANT. So keep it.
        calendar.deactivateDates(new ArrayList<Integer>());

        findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calendar != null && calendar.getSelectedDates() != null){
                    // For Testing---
                    ArrayList<Date> dates = (ArrayList<Date>) calendar.getSelectedDates();

                    for (Date date : dates) {
                        Log.d("fog", "dates: " + date.toString());
                    }
                    //---

                    // TODO: 27-01-2018 Return this value to previous screen using Intent.putExtra()
                    calendar.getSelectedDates();
                }
            }
        });
    }
}
