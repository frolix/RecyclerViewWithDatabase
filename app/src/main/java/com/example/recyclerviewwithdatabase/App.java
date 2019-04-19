package com.example.recyclerviewwithdatabase;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.recyclerviewwithdatabase.database.MainDatabase;

public class App extends Application {
    private static App app;
    private MainDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        database = Room.databaseBuilder(this, MainDatabase.class,"database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getApp() {
        return app;
    }

    public MainDatabase getDatabase() {
        return database;
    }
}
