package com.example.kidslearningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnglishActivity extends AppCompatActivity {

    private List<EngQuestion> engQuestions = new ArrayList<>();
    private ImageView IVEngQ1, IVEngQ2, IVEngQ3;
    private RadioButton RBEngQ1A, RBEngQ1B, RBEngQ2A, RBEngQ2B, RBEngQ3A, RBEngQ3B;
    private int correctAnswerCount = 0;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);

        //Initialise views
        IVEngQ1 = findViewById(R.id.IVEngQ1);
        IVEngQ2 = findViewById(R.id.IVEngQ2);
        IVEngQ3 = findViewById(R.id.IVEngQ3);
        RBEngQ1A = findViewById(R.id.RBEngQ1A);
        RBEngQ1B = findViewById(R.id.RBEngQ1B);
        RBEngQ2A = findViewById(R.id.RBEngQ2A);
        RBEngQ2B = findViewById(R.id.RBEngQ2B);
        RBEngQ3A = findViewById(R.id.RBEngQ3A);
        RBEngQ3B = findViewById(R.id.RBEngQ3B);

        //Initialize Firebase
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Questions");

        //Retrieve all questions from the database
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    EngQuestion question = snapshot.getValue(EngQuestion.class);
                    engQuestions.add(question);
                }

                //Display the questions in the list
                displayQuestions();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Handle error
            }
        });
    }

    private void displayQuestions(){

        //Shuffle the list of questions to randomise order
        Collections.shuffle(engQuestions);

        if (!engQuestions.isEmpty()) {
            EngQuestion Q1 = engQuestions.get(0);
            EngQuestion Q2 = engQuestions.get(1);
            EngQuestion Q3 = engQuestions.get(2);

            //Display questions on ImageViews
            /*IVEngQ1.setImageResource(Q1.getQuestionImage());
            IVEngQ2.setImageResource(Q2.getQuestionImage());
            IVEngQ3.setImageResource(Q3.getQuestionImage());*/

            //Assign correct and wrong answers to radio buttons randomly
            Random random = new Random();
            int correctButtonIndex = random.nextInt(3);
            if (correctButtonIndex == 0) {
                RBEngQ1A.setText(Q1.getCorrectAnswer());
                RBEngQ1A.setTag("correct");
                RBEngQ1B.setText(Q1.getWrongAnswer());
                RBEngQ1B.setTag("wrong");
                RBEngQ2A.setText(Q2.getCorrectAnswer());
                RBEngQ2A.setTag("correct");
                RBEngQ2B.setText(Q2.getWrongAnswer());
                RBEngQ2B.setTag("wrong");
                RBEngQ3A.setText(Q3.getCorrectAnswer());
                RBEngQ3A.setTag("correct");
                RBEngQ3B.setText(Q3.getWrongAnswer());
                RBEngQ3B.setTag("wrong");
            } else if (correctButtonIndex == 1) {
                RBEngQ1A.setText(Q1.getWrongAnswer());
                RBEngQ1A.setTag("wrong");
                RBEngQ1B.setText(Q1.getCorrectAnswer());
                RBEngQ1B.setTag("correct");
                RBEngQ2A.setText(Q2.getWrongAnswer());
                RBEngQ2A.setTag("wrong");
                RBEngQ2B.setText(Q2.getCorrectAnswer());
                RBEngQ2B.setTag("correct");
                RBEngQ3A.setText(Q3.getWrongAnswer());
                RBEngQ3A.setTag("wrong");
                RBEngQ3B.setText(Q3.getCorrectAnswer());
                RBEngQ3B.setTag("correct");
            } else {
                RBEngQ1A.setText(Q1.getWrongAnswer());
                RBEngQ1A.setTag("wrong");
                RBEngQ1B.setText(Q1.getCorrectAnswer());
                RBEngQ1B.setTag("correct");
                RBEngQ2A.setText(Q2.getWrongAnswer());
                RBEngQ2A.setTag("wrong");
                RBEngQ2B.setText(Q2.getCorrectAnswer());
                RBEngQ2B.setTag("correct");
                RBEngQ3A.setText(Q3.getCorrectAnswer());
                RBEngQ3A.setTag("correct");
                RBEngQ3B.setText(Q3.getWrongAnswer());
                RBEngQ3B.setTag("wrong");
            }
        }
    }


}