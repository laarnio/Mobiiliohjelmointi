package com.example.laarnio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        ArrayList<String> calcLog = getIntent().getStringArrayListExtra("laskut");

        for(String item : calcLog){
            TextView newView = new TextView(this);
            newView.setText(item);
            linearLayout.addView(newView);
        }









    }
}
