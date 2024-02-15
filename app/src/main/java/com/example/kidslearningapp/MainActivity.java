package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BtnMathsOnClick(View v){
        Intent intent = new Intent(getApplicationContext(), MathActivity.class);
        startActivity(intent);
    }

    public void BtnEnglishOnClick(View v){
        Intent intent = new Intent(getApplicationContext(), EnglishActivity.class);
        startActivity(intent);
    }
}