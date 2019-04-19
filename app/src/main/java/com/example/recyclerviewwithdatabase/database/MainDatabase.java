package com.example.recyclerviewwithdatabase.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.recyclerviewwithdatabase.dao.UserDao;
import com.example.recyclerviewwithdatabase.entity.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class MainDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
