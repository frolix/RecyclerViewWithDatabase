package com.example.recyclerviewwithdatabase.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.recyclerviewwithdatabase.App;
import com.example.recyclerviewwithdatabase.database.MainDatabase;
import com.example.recyclerviewwithdatabase.entity.User;

import java.util.List;

public class UserViewModel extends ViewModel {
    private MainDatabase database;
    private MutableLiveData<User> newUser;

    public UserViewModel(){
        database = App.getApp().getDatabase();
        newUser = new MutableLiveData<>();
    }

    public MutableLiveData<User>getNewUser(){
        return newUser;
    }

    public void insertUser(User user){
        database.getUserDao().insertUser(user);
        newUser.setValue(user);
    }

    public void deleteUser(User user){
        database.getUserDao().deleteUser(user);
    }
    public List<User> getAllUsers(){
        return  database.getUserDao().getUsers();
    }

}
