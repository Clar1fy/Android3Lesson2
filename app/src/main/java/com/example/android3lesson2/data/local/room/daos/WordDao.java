package com.example.android3lesson2.data.local.room.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.android3lesson2.data.local.room.models.WordModel;

import java.util.List;

import dagger.Provides;

@Dao
public interface WordDao {
    @Insert
    void insert(WordModel wordModel);

    @Query("SELECT * FROM WordModel WHERE category =:userCategory")
    LiveData<List<WordModel>> getAll(String userCategory);
}
