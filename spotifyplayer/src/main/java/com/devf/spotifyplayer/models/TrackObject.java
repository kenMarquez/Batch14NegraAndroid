package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 10/05/17.
 */

public class TrackObject {

    @SerializedName("tracks")
    public Tracks tracks;

    public TrackObject(Tracks tracks) {
        this.tracks = tracks;
    }

    public Tracks getTracks() {
        return tracks;
    }

    public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "TrackObject{" +
                "tracks=" + tracks +
                '}';
    }
}
