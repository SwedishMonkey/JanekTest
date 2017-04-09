package com.example.lucas.janektest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoadStartup(View view) {
        Intent intent = new Intent(this, StartInfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }

}
