package com.example.android3lesson2.data.local;

import androidx.lifecycle.LiveData;

import com.example.android3lesson2.data.local.room.daos.CategoryDao;
import com.example.android3lesson2.data.local.room.daos.WordDao;
import com.example.android3lesson2.data.local.room.models.CategoryModel;
import com.example.android3lesson2.data.local.room.models.WordModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RoomHelper {
    private WordDao wordDao;
    private CategoryDao categoryDao;

    @Inject
    RoomHelper(WordDao wordDao, CategoryDao categoryDao) {
        this.wordDao = wordDao;
        this.categoryDao = categoryDao;
    }

    public CategoryModel insertCategory(CategoryModel categoryModel) {
        categoryDao.insert(categoryModel);
        return categoryModel;
    }

    public LiveData<List<CategoryModel>> getAllCategories() {
        return categoryDao.getAll();

    }

    public WordModel insertWord(WordModel wordModel) {
        wordDao.insert(wordModel);
        return wordModel;
    }

    public LiveData<List<WordModel>> getAllWords(String userCategory) {
        return wordDao.getAll(userCategory);
    }
}
