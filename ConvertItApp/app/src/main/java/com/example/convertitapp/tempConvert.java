package com.example.convertitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class tempConvert extends AppCompatActivity {

    private Button CtF, FtC;
    private TextView tempResult;
    private EditText enterTemp;
    double result1;
    double result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_convert);

        CtF = findViewById(R.id.CtF);
        FtC = findViewById(R.id.FtC);
        tempResult = findViewById(R.id.tempResult);
        enterTemp = findViewById(R.id.enterTemp);



        CtF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double temp = Double.parseDouble(enterTemp.getText().toString());
                result1 = (temp *1.8) + 32;
                tempResult.setText(String.valueOf(result1));
                ImageView img=(ImageView)findViewById(R.id.flag);
                img.setBackgroundResource(R.drawable.usaflag);
            }
        });

        FtC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temp = Double.parseDouble(enterTemp.getText().toString());
                result2 = (temp - 32) / 1.8;
                tempResult.setText(String.valueOf(result2));
                ImageView img=(ImageView)findViewById(R.id.flag);
                img.setBackgroundResource(R.drawable.canadaflag);
            }
        });


    }
}