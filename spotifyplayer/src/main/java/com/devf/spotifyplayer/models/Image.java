package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 11/05/17.
 */

public class Image {

    @SerializedName("url")
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "url='" + url + '\'' +
                '}';
    }
}
