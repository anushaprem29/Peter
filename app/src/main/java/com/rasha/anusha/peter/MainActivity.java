package com.rasha.anusha.peter;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText answer,question;
    TextView command,vanswer;
    Button okay,helpButton;
    int value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = (EditText) findViewById(R.id.editmain);
        question = (EditText) findViewById(R.id.question);
        command = (TextView) findViewById(R.id.textmain);
        vanswer = (TextView) findViewById(R.id.answer);
        okay = (Button) findViewById(R.id.okayButton);
        question.setVisibility(View.INVISIBLE);
        vanswer.setVisibility(View.INVISIBLE);
        okay.setVisibility(View.INVISIBLE);
        helpButton = (Button) findViewById(R.id.info);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setText("");
                new CountDownTimer(4000,1000) {
                    public void onFinish() {
                        command.setText("Rathod, answer my question!");
                    }
                    public void onTick(long millisUntilFinished) {
                    }
                }.start();
                question.setVisibility(View.VISIBLE);
            }
        });
        question.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                okay.setVisibility(View.VISIBLE);
                return false;
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vanswer.setVisibility(View.VISIBLE);
                String ans= answer.getText().toString();
                vanswer.setText(ans);
                okay.setText("Ask Rathod Again");
                answer.setFocusable(false);
                question.setFocusable(false);
                answer.setClickable(false);
                question.setClickable(false);
                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
            }
        });
    }
}