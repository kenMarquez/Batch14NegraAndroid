package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ken on 10/05/17.
 */

public class Album {

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    List<Image> images = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", images=" + images +
                '}';
    }
}
