package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MathActivity extends AppCompatActivity {

    //22004771 Ezekiel

    public static final String PREF_NAME = "MathQuestions";
    public static final String PREF_KEY = "Math";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
    }

    private void submitData() {
        List<String> MathQuestion = new ArrayList<>();
        MathQuestion.add("2 + 2");
        MathQuestion.add("3 + 4");
        MathQuestion.add("6 - 3");
        MathQuestion.add("3 + 4");
        MathQuestion.add("6 - 3");

        // Retrieve existing records from SharedPreferences
        Map<String, List<MathQuestion>> records = getRecords();

    }

    private Map<String, List<MathQuestion>> getRecords() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(PREF_KEY, null);

        if (json == null) {
            return new HashMap<>();  // or handle it in some way appropriate to your application
        }

        Type type = new TypeToken<Map<String, List<MathQuestion>>>() {}.getType();
        return new Gson().fromJson(json, type);
    }
}