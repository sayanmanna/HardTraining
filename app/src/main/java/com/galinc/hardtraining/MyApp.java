package com.galinc.hardtraining;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.galinc.hardtraining.db.AppDatabase;

public class MyApp extends Application {
    public static MyApp instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();

    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
