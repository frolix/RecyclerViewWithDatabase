package com.example.recyclerviewwithdatabase.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "user_name")
    private  String name;

    @ColumnInfo(name = "user_surname")
    private  String surname;

    @ColumnInfo(name = "user_age")
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
