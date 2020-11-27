package com.example.convertitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton massBtn = (ImageButton) findViewById(R.id.massBtn);
        ImageButton currencyBtn = (ImageButton) findViewById(R.id.currencyBtn);
        ImageButton tempBtn = (ImageButton) findViewById(R.id.tempBtn);
        ImageButton lengthBtn = (ImageButton) findViewById(R.id.lenthBtn);
        ImageButton volumeBtn = (ImageButton) findViewById(R.id.volumBtn);
        ImageButton areaBtn = (ImageButton) findViewById(R.id.areaBtn);


        massBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MassConvert.class));
            }
        });


        currencyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CurrencyConvert.class));
            }
        });


        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, tempConvert.class));
            }
        });


        lengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LengthConvert.class));
            }
        });

        volumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Volume.class));
            }
        });

//        areaBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, LengthConvert.class));
//            }
//        });


    }
}