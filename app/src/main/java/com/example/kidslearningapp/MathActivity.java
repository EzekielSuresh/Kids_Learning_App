package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MathActivity extends AppCompatActivity {

    private MathQuestionDataSource dataSource;
    private List<MathQuestion> mathQuestions = new ArrayList<>();
    private TextView TVMathQ1, TVMathQ2, TVMathQ3;
    private RadioButton RBMathQ1A, RBMathQ1B, RBMathQ2A, RBMathQ2B, RBMathQ3A, RBMathQ3B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        //Initialise views
        TVMathQ1 = findViewById(R.id.TVMathQ1);
        TVMathQ2 = findViewById(R.id.TVMathQ2);
        TVMathQ3 = findViewById(R.id.TVMathQ3);
        RBMathQ1A = findViewById(R.id.RBMathQ1A);
        RBMathQ1B = findViewById(R.id.RBMathQ1B);
        RBMathQ2A = findViewById(R.id.RBMathQ2A);
        RBMathQ2B = findViewById(R.id.RBMathQ2B);
        RBMathQ3A = findViewById(R.id.RBMathQ3A);
        RBMathQ3B = findViewById(R.id.RBMathQ3B);

        //Add math questions to list
        mathQuestions.add(new MathQuestion("What is 2 + 2?", "4", "1"));
        mathQuestions.add(new MathQuestion("What is 2 + 3?", "5", "2"));
        mathQuestions.add(new MathQuestion("What is 6 + 2?", "8", "3"));
        mathQuestions.add(new MathQuestion("What is 2 + 1?", "3", "4"));
        mathQuestions.add(new MathQuestion("What is 8 + 2?", "10", "5"));
        mathQuestions.add(new MathQuestion("What is 2 + 8?", "10", "6"));

        dataSource = new MathQuestionDataSource(this);
        dataSource.open();

        //Loop through the list and add questions to database
        for(MathQuestion question : mathQuestions){
            dataSource.addMathQuestion(question);
        }

        //Fetch all math questions from the database
        mathQuestions = dataSource.getAllMathQuestions();

        //Shuffle the list of questions to randomise order
        Collections.shuffle(mathQuestions);

        //Select first 3 questions from shuffle list
        if(mathQuestions.size() >= 3){
            MathQuestion Q1 = mathQuestions.get(0);
            MathQuestion Q2 = mathQuestions.get(1);
            MathQuestion Q3 = mathQuestions.get(2);

            //Display questions on TextViews
            TVMathQ1.setText(Q1.getQuestions());
            TVMathQ2.setText(Q2.getQuestions());
            TVMathQ3.setText(Q3.getQuestions());

            //Assign correct and wrong answers to radio buttons randomly
            Random random = new Random();
            int correctButtonIndex = random.nextInt(3);
            if (correctButtonIndex == 0) {
                RBMathQ1A.setText(Q1.getCorrectAnswer());
                RBMathQ1A.setTag("correct");
                RBMathQ1B.setText(Q1.getWrongAnswer());
                RBMathQ1B.setTag("wrong");
                RBMathQ2A.setText(Q2.getCorrectAnswer());
                RBMathQ2A.setTag("correct");
                RBMathQ2B.setText(Q2.getWrongAnswer());
                RBMathQ2B.setTag("wrong");
                RBMathQ3A.setText(Q3.getCorrectAnswer());
                RBMathQ3A.setTag("correct");
                RBMathQ3B.setText(Q3.getWrongAnswer());
                RBMathQ3B.setTag("wrong");
            } else if (correctButtonIndex == 1) {
                RBMathQ1A.setText(Q1.getWrongAnswer());
                RBMathQ1A.setTag("wrong");
                RBMathQ1B.setText(Q1.getCorrectAnswer());
                RBMathQ1B.setTag("correct");
                RBMathQ2A.setText(Q2.getWrongAnswer());
                RBMathQ2A.setTag("wrong");
                RBMathQ2B.setText(Q2.getCorrectAnswer());
                RBMathQ2B.setTag("correct");
                RBMathQ3A.setText(Q3.getWrongAnswer());
                RBMathQ3A.setTag("wrong");
                RBMathQ3B.setText(Q3.getCorrectAnswer());
                RBMathQ3B.setTag("correct");
            } else {
                RBMathQ1A.setText(Q1.getWrongAnswer());
                RBMathQ1A.setTag("wrong");
                RBMathQ1B.setText(Q1.getCorrectAnswer());
                RBMathQ1B.setTag("correct");
                RBMathQ2A.setText(Q2.getWrongAnswer());
                RBMathQ2A.setTag("wrong");
                RBMathQ2B.setText(Q2.getCorrectAnswer());
                RBMathQ2B.setTag("correct");
                RBMathQ3A.setText(Q3.getCorrectAnswer());
                RBMathQ3A.setTag("correct");
                RBMathQ3B.setText(Q3.getWrongAnswer());
                RBMathQ3B.setTag("wrong");
            }

        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        dataSource.close();
    }

}