package com.example.borrowbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //start main screen after 2 seconds
        new Handler().postDelayed(new Runnable(){
            public void run(){
             startActivity(new Intent(SplashActivity.this,MainActivity.class)); //directing to homepage
             finish(); //finish this activity
            }
        },2000); //2000 means 2 seconds
    }
}