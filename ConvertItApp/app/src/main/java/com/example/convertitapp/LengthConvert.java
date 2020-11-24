package com.example.convertitapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class LengthConvert extends AppCompatActivity {

    EditText fromLenValue;
    TextView output;
    Spinner fromSpinnerValue, toSpinnerValue;
    Button calcLen, clrLen;
    String from, to;
    String[] arrayVal = {"Millimeter", "Centimeter", "Meter", "Inch", "Foot"};
    DecimalFormat precision = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convert);

        //get from edit text value
        fromLenValue = findViewById(R.id.edFromLen);
        //from spinner value
        fromSpinnerValue = findViewById(R.id.spinnerFromLen);
        //to spinner value
        toSpinnerValue = findViewById(R.id.spinnerToLen);
        //convert mass
        calcLen = findViewById(R.id.calcLenBtn);
        //clear mass
        clrLen = findViewById(R.id.clrLenBtn);
        //output value
        output = findViewById(R.id.tvToLen);

        calcLen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sFromMassValue = fromLenValue.getText().toString();

                if (!sFromMassValue.matches("")) {

                    float fromVal = Float.parseFloat(fromLenValue.getText().toString());
                    //Gets selected items from the spinners
                    from = fromSpinnerValue.getSelectedItem().toString();
                    to = toSpinnerValue.getSelectedItem().toString();

                    //FROM MILLIMETER TO...
                    if (from.equalsIgnoreCase(arrayVal[0])) {

                        if (to.equalsIgnoreCase(arrayVal[1])) {
                            MilliToCenti();
                        } else if (to.equalsIgnoreCase(arrayVal[2])) {
                            MilliToMeter();
                        } else if (to.equalsIgnoreCase(arrayVal[3])) {
                            MilliToInch();
                        } else if (to.equalsIgnoreCase(arrayVal[4])) {
                            MilliToFoot();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[1])) {

                        if (to.equalsIgnoreCase(arrayVal[0])) {
                            CentiToMilli();
                        } else if (to.equalsIgnoreCase(arrayVal[2])) {
                            CentiToMeter();
                        } else if (to.equalsIgnoreCase(arrayVal[3])) {
                            CentiToInch();
                        } else if (to.equalsIgnoreCase(arrayVal[4])) {
                            CentiToFoot();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[2])) {

                        if (to.equalsIgnoreCase(arrayVal[0])) {
                            MeterToMilli();
                        } else if (to.equalsIgnoreCase(arrayVal[1])) {
                            MeterToCenti();
                        } else if (to.equalsIgnoreCase(arrayVal[3])) {
                            MeterToInch();
                        } else if (to.equalsIgnoreCase(arrayVal[4])) {
                            MeterToFoot();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[3])) {

                        if (to.equalsIgnoreCase(arrayVal[0])) {
                            InchToMilli();

                        } else if (to.equalsIgnoreCase(arrayVal[1])) {
                            InchToCenti();

                        } else if (to.equalsIgnoreCase(arrayVal[2])) {
                            InchToMeter();

                        } else if (to.equalsIgnoreCase(arrayVal[4])) {
                            InchToFoot();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    } else if (from.equalsIgnoreCase(arrayVal[4])) {

                        if (to.equalsIgnoreCase(arrayVal[0])) {
                            FootToMilli();
                        } else if (to.equalsIgnoreCase(arrayVal[1])) {
                            FootToCenti();
                        } else if (to.equalsIgnoreCase(arrayVal[2])) {
                            FootToMeter();
                        } else if (to.equalsIgnoreCase(arrayVal[3])) {
                            FootToInch();
                        } else {
                            String fromValStr = Float.toString(fromVal);
                            output.setText(fromValStr);
                        }

                    }


                } else {
                    Toast.makeText(LengthConvert.this, "Please enter a numeric value", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });

        clrLen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromLenValue.setText("");
                output.setText("");
            }
        });

    }

    //****FOOT CONVERSION METHODS****
    private void FootToInch() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 12);
        output.setText(precision.format(ans));
    }

    private void FootToMeter() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 3.281);
        output.setText(precision.format(ans));
    }

    private void FootToCenti() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 30.48);
        output.setText(precision.format(ans));
    }

    private void FootToMilli() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 305);
        output.setText(precision.format(ans));
    }


    //****INCH CONVERSION METHODS****
    private void InchToFoot() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 12);
        output.setText(precision.format(ans));
    }

    private void InchToMeter() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 39.37);
        output.setText(precision.format(ans));
    }

    private void InchToCenti() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 2.54);
        output.setText(precision.format(ans));
    }

    private void InchToMilli() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 25.4);
        output.setText(precision.format(ans));
    }


    //****METER CONVERSION METHODS****
    private void MeterToFoot() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 3.281);
        output.setText(precision.format(ans));
    }

    private void MeterToInch() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 39.37);
        output.setText(precision.format(ans));
    }

    private void MeterToCenti() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 100);
        output.setText(precision.format(ans));
    }

    private void MeterToMilli() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 1000);
        output.setText(precision.format(ans));
    }


    //****CENTIMETER CONVERSION METHODS****
    private void CentiToFoot() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 30.38);
        output.setText(precision.format(ans));
    }

    private void CentiToInch() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 2.54);
        output.setText(precision.format(ans));
    }

    private void CentiToMeter() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 100);
        output.setText(precision.format(ans));
    }

    private void CentiToMilli() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal * 10);
        output.setText(precision.format(ans));
    }


    //****MILLIMETER CONVERSION METHODS****
    private void MilliToFoot() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 305);
        output.setText(precision.format(ans));
    }

    private void MilliToInch() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 25.4);
        output.setText(precision.format(ans));
    }

    private void MilliToMeter() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 1000);
        output.setText(precision.format(ans));
    }

    private void MilliToCenti() {
        String val = fromLenValue.getText().toString();
        float fVal = Float.parseFloat(val);
        float ans = (float) (fVal / 10);
        output.setText(precision.format(ans));
    }
}