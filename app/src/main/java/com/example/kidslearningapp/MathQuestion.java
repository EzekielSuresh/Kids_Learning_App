package com.example.kidslearningapp;

public class MathQuestion {

    private String questions;
    private String correctAnswer;
    private String wrongAnswer;

    public MathQuestion(String questions, String correctAnswer, String wrongAnswer) {
        this.questions = questions;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getQuestions() {
        return questions;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }
}
