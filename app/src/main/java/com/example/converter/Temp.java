package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.converter.tempareture.TemparatureConverter;

public class Temp extends AppCompatActivity {
    String[] tempFrom;
    String[] tempTo;
    String fromUnit, toUnit;
    EditText input;
    Button converter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        tempFrom = getResources().getStringArray(R.array.temp_from);
        tempTo = getResources().getStringArray(R.array.temp_to);
        converter = findViewById(R.id.temp_btn_convert);
        input = findViewById(R.id.temp_edt_from);


        final Spinner spinnerFrom = findViewById(R.id.temp_spnr_from);
        final Spinner spinnerTo= findViewById(R.id.temp_spnr_to);

        // make array-adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tempFrom);

        // set adapter
        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromUnit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setAdapter(adapter);
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toUnit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inputValue = Double.parseDouble(input.getText().toString());
                TemparatureConverter tc = new TemparatureConverter(fromUnit, toUnit, inputValue);
                String finalResult = tc.getResult();
                Toast.makeText(Temp.this, finalResult, Toast.LENGTH_LONG).show();
            }
        });
    }
}
