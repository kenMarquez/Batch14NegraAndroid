package com.devf.quizapp.models;

/**
 * Created by Ken on 28/04/17.
 */

public class Pregunta {

    private String title;
    private int value;

    public Pregunta(String title, int value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
