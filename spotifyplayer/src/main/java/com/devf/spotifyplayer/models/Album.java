package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 10/05/17.
 */

public class Album {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                '}';
    }
}
