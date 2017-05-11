package com.devf.spotifyplayer.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ken on 10/05/17.
 */

public class Tracks {

    @SerializedName("total")
    public int total;

    @SerializedName("items")
    public List<Item> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
