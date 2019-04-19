package com.example.recyclerviewwithdatabase.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.recyclerviewwithdatabase.R;
import com.example.recyclerviewwithdatabase.adapter.UserAdapter;
import com.example.recyclerviewwithdatabase.entity.User;
import com.example.recyclerviewwithdatabase.view.fragment.AddUserDialog;
import com.example.recyclerviewwithdatabase.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton buttonAddUser;
    private RecyclerView userList;
    private UserViewModel model;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setListener();
        observe();
    }

    private void observe() {
        model.getNewUser().observe(this, newUser ->{
            adapter.addUser(newUser);
        });
    }

    private void setListener() {

        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }

    private void init() {
        buttonAddUser = findViewById(R.id.floating_action_button);

        model = ViewModelProviders.of(this).get(UserViewModel.class);

        userList = findViewById(R.id.users_list);
        userList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        userList.setAdapter(adapter);
    }

    public void openDialog() {
        AddUserDialog exampleDialog = new AddUserDialog();
        exampleDialog.show(getSupportFragmentManager(), "exemple dailog");
    }
}
