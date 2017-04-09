package com.example.lucas.janektest;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class PenRiddleActivity extends AppCompatActivity {

    private EditText countdownField;
    private EditText AnswerText;
    private CountDownTimer bombTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pen_riddle);

        AnswerText = (EditText)findViewById(R.id.penRiddleAnswer);
        countdownField = (EditText) findViewById(R.id.coundownField);

        startCountdown();
    }

    @Override
    public void onBackPressed() {

    }

    public void startCountdown() {
        bombTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                countdownField.setText("" + millisUntilFinished / 1000 + " sekunder");
            }

            public void onFinish() {
                countdownField.setText("BOOM!");

                //Network code to blow up bomb
            }

        }.start();
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        }
    };

    public void CheckPenAnswer(View view) {
        if (AnswerText.getText().toString().toLowerCase().equals("mot väggen")) {
            bombTimer.cancel();
            findViewById(R.id.blowupText).setVisibility(View.INVISIBLE);
            findViewById(R.id.disarmed).setVisibility(View.VISIBLE);
            Handler mHandler = new Handler();
            mHandler.postDelayed(mRunnable, 5000);
        } else {
            //Reduce time
        }
    }
}
