package com.example.android3lesson2.di;

import com.example.android3lesson2.data.local.room.daos.CategoryDao;
import com.example.android3lesson2.data.local.room.daos.WordDao;
import com.example.android3lesson2.data.local.room.database.AppDatabase;
import com.example.android3lesson2.utils.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    @Singleton
    @Provides
    public AppDatabase provideDatabase(AppDatabase appDatabase) {
        return App.getDb();

    }

    @Singleton
    @Provides
    public WordDao provideWordDao(AppDatabase appDatabase) {
//        return App.getDb().wordDao();
        return appDatabase.wordDao();
    }

    @Singleton
    @Provides
    public CategoryDao provideCategoryDao(AppDatabase appDatabase) {
//        return App.getDb().categoryDao();
        return appDatabase.categoryDao();
    }
}
