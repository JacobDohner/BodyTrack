package com.dohner.bodytrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    Button saveCurrentWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }


    public void addListenerOnButton() {
        saveCurrentWeight = (Button) findViewById(R.id.saveCurrentWeightButton);

        saveCurrentWeight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {


            }

        });

    }


    }

