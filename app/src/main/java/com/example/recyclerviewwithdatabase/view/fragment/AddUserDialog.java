package com.example.recyclerviewwithdatabase.view.fragment;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerviewwithdatabase.App;
import com.example.recyclerviewwithdatabase.R;
import com.example.recyclerviewwithdatabase.database.MainDatabase;
import com.example.recyclerviewwithdatabase.entity.User;
import com.example.recyclerviewwithdatabase.viewmodel.UserViewModel;

public class AddUserDialog extends AppCompatDialogFragment {
    private EditText userNameEditText;
    private EditText userSurnameEditText;
    private EditText userAgeEditText;

    private UserViewModel model;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog,null);
        init(view);

        builder.setView(view)
                .setTitle("ADD NEW USER")
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isFieldsFilled()){
                            String name = userNameEditText.getText().toString();
                            String surname = userSurnameEditText.getText().toString();
                            int age = Integer.valueOf(userAgeEditText.getText().toString());

                            model.insertUser(new User(name,surname,age));
                        }else {
                            Toast.makeText(getContext(), "Fill in all fields", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        return builder.create();
    }

    private boolean isFieldsFilled(){
        return !TextUtils.isEmpty(userNameEditText.getText().toString())&&
                !TextUtils.isEmpty(userSurnameEditText.getText().toString())&&
                !TextUtils.isEmpty(userAgeEditText.getText().toString());
    }

    private void init(View view) {
        userNameEditText = view.findViewById(R.id.edit_name);
        userSurnameEditText = view.findViewById(R.id.edit_surname);
        userAgeEditText = view.findViewById(R.id.edit_age);

        model = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
    }
}
