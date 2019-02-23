package com.example.taskmanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.taskmanager.R;
import com.example.taskmanager.models.Task;

import java.io.Serializable;

public class Activity2 extends AppCompatActivity {

    String taskTitle;
    String taskDescription;
    int taskImage;

    EditText etTaskTitle;
    EditText etTaskDescription;
    EditText etImage;

    static final String TASK_KEY="Task";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        etTaskTitle=findViewById(R.id.task_title_edit_text);
        etTaskDescription=findViewById(R.id.task_description_edit_text);
        etImage=findViewById(R.id.task_image_edit_text);
        addTextChangeListener();

    }

    private void addTextChangeListener() {
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

    void onSaveTask(View view) {
        Task newTask=new Task(taskTitle,taskDescription,taskImage);
        Intent intent=new Intent();
        intent.putExtra(TASK_KEY, (Serializable) newTask);
        setResult(RESULT_OK,intent);
        finish();
    }
}
