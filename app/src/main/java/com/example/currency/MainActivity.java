package com.example.currency;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText inputField;
    public TextView resultText;
    public Button convert;
    public Button info;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public Switch switchBox;
    double currPlnToUsd = 0.27;
    double currUsdToPln = 3.65;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        resultText = findViewById(R.id.resultText);
        convert = findViewById(R.id.convert);
        info = findViewById(R.id.btnInfo);
        switchBox = findViewById(R.id.switchBox);

        convert.setOnClickListener(v -> {
            boolean switchState = switchBox.isChecked();
            String value = inputField.getText().toString();
            if(value.isEmpty()) {
                Toast.makeText(MainActivity.this, "Input a value, please", Toast.LENGTH_LONG).show();
                inputField.setError("This field cannot be empty");
            }
            else {
                float convert_result = Float.parseFloat(value);
                if(switchState) {
                    convert_result *= currUsdToPln;
                }
                else {
                    convert_result *= currPlnToUsd;
                }
                resultText.setText(String.format("%,.2f", convert_result));
            }
        });

        info.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    ActivityInfo2.class);
            intent.putExtra("currUsdToPln", currUsdToPln);
            intent.putExtra("currPlnToUsd", currPlnToUsd);
            startActivity(intent);
        });
    }
}