package com.example.android3lesson2.data.local.room.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String title;

    public CategoryModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
