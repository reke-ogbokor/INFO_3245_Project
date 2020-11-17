package com.example.convertitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button massBtn = (Button) findViewById(R.id.massBtn);
        Button currencyBtn = (Button) findViewById(R.id.currencyBtn);
        Button tempBtn = (Button) findViewById(R.id.tempBtn);


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


    }
}