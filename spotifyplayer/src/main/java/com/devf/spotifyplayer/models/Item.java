package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 10/05/17.
 */

public class Item {

    @SerializedName("preview_url")
    private String previewUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("album")
    private Album album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Item{" +
                "previewUrl='" + previewUrl + '\'' +
                ", name='" + name + '\'' +
                ", album=" + album +
                '}';
    }
}
