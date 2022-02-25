package com.example.android3lesson2.utils.app;

import android.app.Application;

import androidx.room.Room;

import com.example.android3lesson2.data.local.room.database.AppDatabase;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {
    static AppDatabase db;
    static App app;

    public static AppDatabase getDb() {
        if (db != null) {
            return db;
        } else {
            return null;

        }
    }

    public static App getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();


    }
}
