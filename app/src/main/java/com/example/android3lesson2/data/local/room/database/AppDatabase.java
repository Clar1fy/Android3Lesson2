package com.example.android3lesson2.data.local.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android3lesson2.data.local.room.daos.CategoryDao;
import com.example.android3lesson2.data.local.room.daos.WordDao;
import com.example.android3lesson2.data.local.room.models.CategoryModel;
import com.example.android3lesson2.data.local.room.models.WordModel;

@Database(entities = {CategoryModel.class, WordModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();

    public abstract WordDao wordDao();
}
