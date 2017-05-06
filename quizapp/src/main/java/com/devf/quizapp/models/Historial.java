package com.devf.quizapp.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ken on 05/05/17.
 */

public class Historial extends RealmObject {

    private String userName;
    private int score;

    @PrimaryKey
    private long id;

    public Historial() {
    }

    public Historial(String userName, int score, long id) {
        this.userName = userName;
        this.score = score;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "userName='" + userName + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}
