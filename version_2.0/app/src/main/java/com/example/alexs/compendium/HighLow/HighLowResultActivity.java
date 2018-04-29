package com.example.alexs.compendium.HighLow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.alexs.compendium.R;

public class HighLowResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_low_result);

        Intent intent = getIntent();
        String displayGameResult  = (String) intent.getSerializableExtra("displayGameResult");

        TextView result = findViewById(R.id.resultTextViewID);
        result.setText(displayGameResult);
    }


}
