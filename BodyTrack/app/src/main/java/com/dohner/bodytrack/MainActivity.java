package com.dohner.bodytrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.lang.Object;

public class MainActivity extends AppCompatActivity {

    Button saveCurrentWeight;
    ArrayList currentWeightTrackingList;
    ArrayList currentWeightDateList;
    EditText currentWeightText;
    Calendar cal;
    String dateBunch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWeightTrackingList = new ArrayList<>();
        currentWeightDateList = new ArrayList<>();
        currentWeightText = (EditText) findViewById(R.id.currentWeightText);
        cal = Calendar.getInstance();
        dateBunch = new String();

        addListenerOnButton();
    }


    public void addListenerOnButton() {
        saveCurrentWeight = (Button) findViewById(R.id.saveCurrentWeightButton);

        saveCurrentWeight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(currentWeightText!=null) {
                currentWeightTrackingList.add(saveCurrentWeight);
                dateBunch = Integer.toString(cal.MONTH) + "." + Integer.toString(cal.DAY_OF_MONTH) + "." + Integer.toString(cal.YEAR);
                currentWeightDateList.add(dateBunch);
                }
                }



        });

    }


    }

