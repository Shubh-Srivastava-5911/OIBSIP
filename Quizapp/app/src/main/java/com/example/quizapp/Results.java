package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView scoring;
    RadioButton rb11, rb12, rb13, rb14;
    RadioButton rb21, rb22, rb23, rb24;
    RadioButton rb31, rb32, rb33, rb34;
    RadioButton rb41, rb42, rb43, rb44;
    RadioButton rb51, rb52, rb53, rb54;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        scoring = findViewById(R.id.scoring);
        rb11=findViewById(R.id.op11); rb12=findViewById(R.id.op12); rb13=findViewById(R.id.op13); rb14=findViewById(R.id.op14);
        rb21=findViewById(R.id.op21); rb22=findViewById(R.id.op22); rb23=findViewById(R.id.op23); rb24=findViewById(R.id.op24);
        rb31=findViewById(R.id.op31); rb32=findViewById(R.id.op32); rb33=findViewById(R.id.op33); rb34=findViewById(R.id.op34);
        rb41=findViewById(R.id.op41); rb42=findViewById(R.id.op42); rb43=findViewById(R.id.op43); rb44=findViewById(R.id.op44);
        rb51=findViewById(R.id.op51); rb52=findViewById(R.id.op52); rb53=findViewById(R.id.op53); rb54=findViewById(R.id.op54);

        int c1 = MainActivity.hm.get("q1");
        switch (c1) {
            case 1: rb11.setChecked(true);
                    rb11.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 2: rb12.setChecked(true);
                    rb12.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 3: rb13.setChecked(true);
                    MainActivity.score++;
                    break;
            case 4: rb14.setChecked(true);
                    rb14.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
        }

        int c2 = MainActivity.hm.get("q2");
        switch (c2) {
            case 1: rb21.setChecked(true);
                    rb21.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 2: rb22.setChecked(true);
                    MainActivity.score++;
                    break;
            case 3: rb23.setChecked(true);
                    rb23.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 4: rb24.setChecked(true);
                    rb24.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
        }

        int c3 = MainActivity.hm.get("q3");
        switch (c3) {
            case 1: rb31.setChecked(true);
                    MainActivity.score++;
                    break;
            case 2: rb32.setChecked(true);
                    rb32.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 3: rb33.setChecked(true);
                    rb33.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 4: rb34.setChecked(true);
                    rb34.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
        }

        int c4 = MainActivity.hm.get("q4");
        switch (c4) {
            case 1: rb41.setChecked(true);
                    rb41.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 2: rb42.setChecked(true);
                    rb42.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 3: rb43.setChecked(true);
                    rb43.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 4: rb44.setChecked(true);
                    MainActivity.score++;
                    break;
        }

        int c5 = MainActivity.hm.get("q5");
        switch (c5) {
            case 1: rb51.setChecked(true);
                    rb51.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 2: rb52.setChecked(true);
                    rb52.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 3: rb53.setChecked(true);
                    rb53.setBackgroundColor(Color.parseColor("#FAB4B4"));
                    break;
            case 4: rb54.setChecked(true);
                    MainActivity.score++;
                    break;
        }

        scoring.setText(MainActivity.score+"/5");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Results.this, MainActivity.class));
        finish();
    }
}