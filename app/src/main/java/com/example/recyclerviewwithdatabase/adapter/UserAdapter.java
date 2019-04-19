package com.example.recyclerviewwithdatabase.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewwithdatabase.R;
import com.example.recyclerviewwithdatabase.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> users;


    public UserAdapter(){
         users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
        notifyItemInserted(users.size()-1);
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserHolder(LayoutInflater.from(viewGroup.getContext()),viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        userHolder.bind(users.get(i));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView userSurname;
        private TextView userAge;

        public UserHolder(LayoutInflater inflater, ViewGroup group) {
            super(inflater.inflate(R.layout.user_item, group, false));
            init();
        }

        private void init() {
            userName = itemView.findViewById(R.id.user_name);
            userSurname = itemView.findViewById(R.id.user_surname);
            userAge = itemView.findViewById(R.id.user_age);
        }


        public void bind(User user) {
            userName.setText(user.getName());
            userSurname.setText(user.getSurname());
            userAge.setText(String.valueOf(user.getAge()));
        }

    }
}
