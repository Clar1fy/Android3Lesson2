package com.example.android3lesson2.di;

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
}
