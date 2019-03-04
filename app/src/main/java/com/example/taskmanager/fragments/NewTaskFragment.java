package com.example.taskmanager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.taskmanager.R;
import com.example.taskmanager.models.Task;

public class NewTaskFragment extends Fragment {

    String taskTitle;
    String taskDescription;
    int taskImage;

    EditText etTaskTitle;
    EditText etTaskDescription;
    EditText etImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_new_task,container,false);
        etTaskTitle=view.findViewById(R.id.task_title_edit_text);
        etTaskDescription=view.findViewById(R.id.task_description_edit_text);
        etImage=view.findViewById(R.id.task_image_edit_text);
        addTextListener();

        return view;
    }

    private void addTextListener() {
        etTaskTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                taskTitle=etTaskTitle.getText().toString();
            }
        });
        etTaskDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                taskDescription=etTaskDescription.getText().toString();
            }
        });
        etImage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp=etImage.getText().toString();
                taskImage=Integer.parseInt(temp);
            }
        });

    }

    public Task getTask(){
        return new Task(taskTitle,taskDescription,taskImage);
    }


}
