package com.example.convertitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class Volume extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Double input;
    Spinner spinner;
    String spinnerText;
    ArrayList<SpannableString> unitList = new ArrayList<>();
    EditText editText;
    ArrayList<String> resultsArray = new ArrayList<>();
    TextView[] textViews = new TextView[12];
    TextView[] resultTextViews = new TextView[12];
    Converter converter = new Converter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        spinner = findViewById(R.id.spinner);
        fillSpinner();
        initializeUnitTextView();

        editText = findViewById(R.id.editTextNumber);
        editText.setText("0", TextView.BufferType.EDITABLE);
        converter.setUnit("m3");
        converter.setInput(1.0);
        resultsArray = converter.convertVolume();
        updateResultTextView();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if(charSequence.length() == 0)
                   input = 0.0;
                else {
                    input = Double.parseDouble(editText.getText().toString());
                }

                converter.setInput(input);
                converter.setUnit(spinnerText);

                resultsArray = converter.convertVolume();
                updateResultTextView();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





    }

    private void fillSpinner() {
        unitListInitializer();
        ArrayAdapter<SpannableString> arrayAdapter = new ArrayAdapter<SpannableString>(this, R.layout.support_simple_spinner_dropdown_item, unitList);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        input = Double.parseDouble(editText.getText().toString());
        spinnerText = adapterView.getItemAtPosition(i).toString();

        converter.setInput(input);
        converter.setUnit(spinnerText);

        resultsArray = converter.convertVolume();
        updateResultTextView();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    private void unitListInitializer() {

        SpannableString string = new SpannableString("m3");
        string.setSpan(new SuperscriptSpan(), 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(0.75f), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        unitList.add(string);

        string = new SpannableString("km3");
        string.setSpan(new SuperscriptSpan(), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        unitList.add(string);

        string = new SpannableString("cm3");
        string.setSpan(new SuperscriptSpan(), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        unitList.add(string);

        string = new SpannableString("mm3");
        string.setSpan(new SuperscriptSpan(), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new RelativeSizeSpan(0.75f), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        unitList.add(string);

        unitList.addAll(Arrays.asList(
        new SpannableString("l"),
                new SpannableString("ml"),
                new SpannableString("gal (US)"),
                new SpannableString("qt (US)"),
                new SpannableString("pt (US)"),
                new SpannableString("fl oz (US)"),
                new SpannableString("tbsp (US)"),
                new SpannableString("tsp (US)" )));

    }

    private void initializeUnitTextView() {

        for (int i = 0; i < textViews.length; i++) {
            switch (i) {
                case 0:
                    textViews[i] = findViewById(R.id.textView_0);
                    resultTextViews[i] = findViewById(R.id.textView_result_0);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 1:
                    textViews[i] = findViewById(R.id.textView_1);
                    resultTextViews[i] = findViewById(R.id.textView_result_1);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 2:
                    textViews[i] = findViewById(R.id.textView_2);
                    resultTextViews[i] = findViewById(R.id.textView_result_2);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 3:
                    textViews[i] = findViewById(R.id.textView_3);
                    resultTextViews[i] = findViewById(R.id.textView_result_3);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 4:
                    textViews[i] = findViewById(R.id.textView_4);
                    resultTextViews[i] = findViewById(R.id.textView_result_4);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 5:
                    textViews[i] = findViewById(R.id.textView_5);
                    resultTextViews[i] = findViewById(R.id.textView_result_5);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 6:
                    textViews[i] = findViewById(R.id.textView_6);
                    resultTextViews[i] = findViewById(R.id.textView_result_6);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 7:
                    textViews[i] = findViewById(R.id.textView_7);
                    resultTextViews[i] = findViewById(R.id.textView_result_7);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 8:
                    textViews[i] = findViewById(R.id.textView_8);
                    resultTextViews[i] = findViewById(R.id.textView_result_8);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 9:
                    textViews[i] = findViewById(R.id.textView_9);
                    resultTextViews[i] = findViewById(R.id.textView_result_9);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 10:
                    textViews[i] = findViewById(R.id.textView_10);
                    resultTextViews[i] = findViewById(R.id.textView_result_10);
                    textViews[i].setText(unitList.get(i));
                    break;
                case 11:
                    textViews[i] = findViewById(R.id.textView_11);
                    resultTextViews[i] = findViewById(R.id.textView_result_11);
                    textViews[i].setText(unitList.get(i));
                    break;
            }

        }

    }

    private void updateResultTextView() {


        for (int i = 0; i < resultTextViews.length; i++) {
            switch (i) {
                case 0:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 1:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 2:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 3:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 4:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 5:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 6:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 7:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 8:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 9:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 10:
                    resultTextViews[i].setText(resultsArray.get(i));
                case 11:
                    resultTextViews[i].setText(resultsArray.get(i));
            }

        }
    }

}