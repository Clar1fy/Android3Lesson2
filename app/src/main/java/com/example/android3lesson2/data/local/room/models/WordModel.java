package com.example.android3lesson2.data.local.room.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String word;
    private String category;
    private int image;

    public WordModel(String word, String category) {
        this.word = word;
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public String getWord() {
        return word;
    }

    public String getCategory() {
        return category;
    }


}
