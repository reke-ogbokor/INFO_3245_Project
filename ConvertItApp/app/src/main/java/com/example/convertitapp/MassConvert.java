package com.example.convertitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MassConvert extends AppCompatActivity {

    EditText fromMassValue;
    TextView output;
    Spinner fromSpinnerValue, toSpinnerValue;
    Button calcMass, clrMass;
    String from, to;
    String[] arrayVal = {"Kilogram", "Gram", "Milligram", "Pound"};
    DecimalFormat precision = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_convert);

        //get from edit text value
        fromMassValue = findViewById(R.id.edFrom);
        //from spinner value
        fromSpinnerValue = findViewById(R.id.spinnerFrom);
        //to spinner value
        toSpinnerValue = findViewById(R.id.spinnerTo);
        //convert mass
        calcMass = findViewById(R.id.calcMassBtn);
        //clear mass
        clrMass = findViewById(R.id.clrMassBtn);
        //output value
        output = findViewById(R.id.tvTo);

        calcMass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sFromMassValue = fromMassValue.getText().toString();

                if (!sFromMassValue.matches("")) {

                    float fromVal = Float.parseFloat(fromMassValue.getText().toString());
                    //Gets selected items from the spinners
                    from = fromSpinnerValue.getSelectedItem().toString();
                    to = toSpinnerValue.getSelectedItem().toString();

                    if (from.equalsIgnoreCase(arrayVal[0])){

                        if (to.equalsIgnoreCase(arrayVal[1])){
                            KiloToGram();
                        } else if (to.equalsIgnoreCase(arrayVal[2])){
                            KiloToMilli();
                        } else if (to.equalsIgnoreCase(arrayVal[3])){
                            KiloToPound();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[1])) {

                        if (to.equalsIgnoreCase(arrayVal[0])){
                            GramToKilo();
                        } else if (to.equalsIgnoreCase(arrayVal[2])){
                            GramToMilli();
                        } else if (to.equalsIgnoreCase(arrayVal[3])){
                            GramToPound();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[2])) {

                        if (to.equalsIgnoreCase(arrayVal[1])){
                            MilliToGram();
                        } else if (to.equalsIgnoreCase(arrayVal[0])){
                            MilliToKilo();
                        } else if (to.equalsIgnoreCase(arrayVal[3])){
                            MilliToPound();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[3])) {

                        if (to.equalsIgnoreCase(arrayVal[1])){
                            PoundToGram();
                        } else if (to.equalsIgnoreCase(arrayVal[2])){
                            PoundToMilligram();
                        } else if (to.equalsIgnoreCase(arrayVal[0])){
                            PoundToKilogram();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    }
                } else {
                    Toast.makeText(MassConvert.this, "Please enter a numeric value", Toast.LENGTH_SHORT).show();
                    return;
                }



            }
        });

        clrMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromMassValue.setText("");
                output.setText("");
            }
        });

    }


    //****POUND CONVERSION METHODS****
    private void PoundToKilogram() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 2.205);
        output.setText(precision.format(ans));
    }

    private void PoundToMilligram() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal * 453592;
        output.setText(precision.format(ans));
    }

    private void PoundToGram() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal * 454;
        output.setText(precision.format(ans));
    }


    //****MILLIGRAM CONVERSION METHODS****
    private void MilliToPound() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal / 453592;
        output.setText(precision.format(ans));
    }

    private void MilliToKilo() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal / 1000000;
        output.setText(precision.format(ans));
    }

    private void MilliToGram() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal / 1000;
        output.setText(precision.format(ans));
    }


    //****GRAM CONVERSION METHODS****
    private void GramToMilli() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal * 1000;
        output.setText(precision.format(ans));
    }

    private void GramToPound() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal / 454;
        output.setText(precision.format(ans));
    }

    private void GramToKilo() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal / 1000;
        output.setText(precision.format(ans));
    }


    //****KILOGRAM CONVERSION METHODS****
    private void KiloToPound() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 2.205);
        output.setText(precision.format(ans));
    }

    private void KiloToMilli() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal * 1000000;
        output.setText(precision.format(ans));
    }

    private void KiloToGram() {
        String val = fromMassValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = fVal * 1000;
        output.setText(precision.format(ans));
    }


}