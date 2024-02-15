package com.example.kidslearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MathQuestionDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public MathQuestionDataSource(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void addMathQuestion(MathQuestion mathQuestion){
        ContentValues values = new ContentValues();
        values.put("question", mathQuestion.getQuestions());
        values.put("correctAnswer", mathQuestion.getCorrectAnswer());
        values.put("wrongAnswer", mathQuestion.getWrongAnswer());

        database.insert("MathQuestions", null, values);
    }

    public List<MathQuestion> getAllMathQuestions(){
        List<MathQuestion> mathQuestions = new ArrayList<>();
        Cursor cursor = database.query("MathQuestions", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            String question = cursor.getString(1);
            String correctAnswer = cursor.getString(2);
            String wrongAnswer = cursor.getString(3);
            MathQuestion mathQuestion = new MathQuestion(question, correctAnswer, wrongAnswer);
            mathQuestions.add(mathQuestion);
            cursor.moveToNext();
        }
        cursor.close();
        return mathQuestions;
    }
}
