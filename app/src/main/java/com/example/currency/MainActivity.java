package com.example.currency;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public EditText inputField;
    public TextView resultText;
    public Button convert;
    public Button info;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    public Switch switchBox;

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
            float convert_result = Float.parseFloat(value);
            if(switchState) {
                convert_result *= 3.65;
            }
            else {
                convert_result *= 0.27;
            }
            resultText.setText(String.valueOf(convert_result));
        });

        info.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,
                    ActivityInfo2.class);
            startActivity(intent);
        });
    }
}