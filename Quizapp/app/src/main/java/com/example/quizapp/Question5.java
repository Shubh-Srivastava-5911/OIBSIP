package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {
    TextView back, end;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        back = findViewById(R.id.back);
        end = findViewById(R.id.end);
        rb1 = findViewById(R.id.op1);
        rb2 = findViewById(R.id.op2);
        rb3 = findViewById(R.id.op3);
        rb4 = findViewById(R.id.op4);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) { MainActivity.hm.put("q5",1); }
                else if(rb2.isChecked()) { MainActivity.hm.put("q5",2); }
                else if(rb3.isChecked()) { MainActivity.hm.put("q5",3); }
                else if(rb4.isChecked()) { MainActivity.hm.put("q5",4); }

                if(MainActivity.hm.size()==5) {
                    startActivity(new Intent(Question5.this, Results.class));
                    finish();
                } else {
                    Toast.makeText(Question5.this, "attempt all questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) { MainActivity.hm.put("q5",1); }
                else if(rb2.isChecked()) { MainActivity.hm.put("q5",2); }
                else if(rb3.isChecked()) { MainActivity.hm.put("q5",3); }
                else if(rb4.isChecked()) { MainActivity.hm.put("q5",4); }
                startActivity(new Intent(Question5.this, Question4.class));
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(MainActivity.hm.get("q5")!=null) {
            int choice = MainActivity.hm.get("q5");
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