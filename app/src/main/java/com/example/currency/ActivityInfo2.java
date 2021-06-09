package com.example.currency;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInfo2 extends AppCompatActivity {

    public Button back;
    public TextView actualToPln;
    public TextView actualToUsd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        back = findViewById(R.id.btnBack);
        actualToPln = findViewById(R.id.actualToPln);
        actualToUsd = findViewById(R.id.actualToUsd);

        Bundle arguments = getIntent().getExtras();
        String currUsdToPln = arguments.get("currUsdToPln").toString();
        String currPlnToUsd = arguments.get("currPlnToUsd").toString();
        actualToPln.setText(currUsdToPln);
        actualToUsd.setText(currPlnToUsd);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityInfo2.this,
                    MainActivity.class);
            startActivity(intent);
        });

    }
}