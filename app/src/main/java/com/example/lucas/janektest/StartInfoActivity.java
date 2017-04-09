package com.example.lucas.janektest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class StartInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_info);
    }

    @Override
    public void onBackPressed() {

    }

    public void LoadPuzzle(View view) {
        // Here, we are generating a random number
        Random generator = new Random();
        int number = generator.nextInt(2) + 1;
        // The '5' is the number of activities

        Class activity = null;

        // Here, we are checking to see what the output of the random was
        switch(number) {
            case 1:
                activity = RiddleCornActivity.class;
                break;
            case 2:
                activity = PenRiddleActivity.class;
                break;
            /*case 3:
                activity = ActivityThree.class;
                break;
            case 4:
                activity = ActivityFour.class;
                break;
            default:
                activity = ActivityFive.class;
                break;*/
        }
        // We use intents to start activities
        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
    }

}
