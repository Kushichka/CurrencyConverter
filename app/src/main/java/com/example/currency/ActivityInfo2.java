package com.example.currency;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInfo2 extends AppCompatActivity {

    public Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        back = findViewById(R.id.btnBack);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityInfo2.this,
                    MainActivity.class);
            startActivity(intent);
        });

    }
}