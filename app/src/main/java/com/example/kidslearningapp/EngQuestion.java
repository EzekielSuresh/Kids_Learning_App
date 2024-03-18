package com.example.kidslearningapp;

public class EngQuestion {

    private String questionImage;
    private String correctAnswer;
    private String wrongAnswer;

    public EngQuestion(){}

    public EngQuestion(String questionImage, String correctAnswer, String wrongAnswer) {
        this.questionImage = questionImage;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getQuestionImage() {
        return questionImage;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswer() {
        return wrongAnswer;
    }
}
