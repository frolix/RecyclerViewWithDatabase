package com.example.recyclerviewwithdatabase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.recyclerviewwithdatabase.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Query("SELECT * FROM users WHERE id == :id")
    User getUserById(long id);

    @Insert
    long insertUser(User user);

}
