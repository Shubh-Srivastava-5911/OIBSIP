package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Question3 extends AppCompatActivity {
    TextView back, next;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        rb1 = findViewById(R.id.op1);
        rb2 = findViewById(R.id.op2);
        rb3 = findViewById(R.id.op3);
        rb4 = findViewById(R.id.op4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) { MainActivity.hm.put("q3",1); }
                else if(rb2.isChecked()) { MainActivity.hm.put("q3",2); }
                else if(rb3.isChecked()) { MainActivity.hm.put("q3",3); }
                else if(rb4.isChecked()) { MainActivity.hm.put("q3",4); }
                startActivity(new Intent(Question3.this, Question4.class));
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) { MainActivity.hm.put("q3",1); }
                else if(rb2.isChecked()) { MainActivity.hm.put("q3",2); }
                else if(rb3.isChecked()) { MainActivity.hm.put("q3",3); }
                else if(rb4.isChecked()) { MainActivity.hm.put("q3",4); }
                startActivity(new Intent(Question3.this, Question2.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(MainActivity.hm.get("q3")!=null) {
            int choice = MainActivity.hm.get("q3");
            if (choice == 1) rb1.setChecked(true);
            else if (choice == 2) rb2.setChecked(true);
            else if (choice == 3) rb3.setChecked(true);
            else if (choice == 4) rb4.setChecked(true);
        }
    }

    @Override
    public void onBackPressed() {

    }
}