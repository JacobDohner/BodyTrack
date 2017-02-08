package com.dohner.bodytrack;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Calendar;




public class MainActivity extends AppCompatActivity {

    DBHelper mydb;

    ArrayList currentWeightTrackingList;
    ArrayList currentWeightDateList;

    Button saveCurrentWeight;
    EditText currentWeightText;
    TextView weightPreviousLabel;
    TextView weightTodayLabel;

    Calendar cal;
    String dateBunch;
    String currentWeightString;
    int trackList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWeightTrackingList = new ArrayList<>();
        currentWeightDateList = new ArrayList<>();
        currentWeightText = (EditText) findViewById(R.id.currentWeightText);
        weightTodayLabel = (TextView) findViewById(R.id.weightTodayLabel);
        weightPreviousLabel = (TextView) findViewById(R.id.weightPreviousLabel);
        cal = Calendar.getInstance();
        dateBunch = new String();
        currentWeightString = "";


        addListenerOnButton();
    }


    public void addListenerOnButton() {
        saveCurrentWeight = (Button) findViewById(R.id.saveCurrentWeightButton);

        saveCurrentWeight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(currentWeightText!=null) {
                currentWeightTrackingList.add(currentWeightText.getText());
                //dateBunch = Integer.toString(cal.DAY_OF_MONTH) + "." + Integer.toString(cal.MONTH) + "." + Integer.toString(cal.YEAR);
                //currentWeightDateList.add(dateBunch);
                if(currentWeightTrackingList.size() > 0) {
                    trackList = currentWeightTrackingList.size() - 1;
                    currentWeightString.equals(currentWeightTrackingList.get(trackList));
                    weightTodayLabel.setText(currentWeightString);
                }
                if(currentWeightTrackingList.size() >  2) {
                    weightPreviousLabel.setText(currentWeightTrackingList.size() - 2);
                }
                }
                }



        });

    }


    }




