package com.example.taskmanager.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.taskmanager.R;
import com.example.taskmanager.adapters.TaskAdapter;
import com.example.taskmanager.fragments.NewTaskFragment;
import com.example.taskmanager.fragments.RecyclerViewFragment;
import com.example.taskmanager.interfaces.IOnClickListener;
import com.example.taskmanager.models.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IOnClickListener {

    ArrayList<Task> tasks;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    RecyclerViewFragment recyclerViewFragment;
    NewTaskFragment newTaskFragment;

    String taskTitle;
    String taskDescription;
    int taskImage;

    EditText etTaskTitle;
    EditText etTaskDescription;
    EditText etImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        recyclerViewFragment=new RecyclerViewFragment();
        recyclerViewFragment.setTasks();
        fragmentTransaction.add(R.id.frame_layout,recyclerViewFragment);
        fragmentTransaction.commit();

    }



    public void addNewTask(View v){
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.remove(recyclerViewFragment);
        fragmentTransaction.commit();
        fragmentTransaction=fragmentManager.beginTransaction();
        newTaskFragment=new NewTaskFragment();
        fragmentTransaction.add(R.id.frame_layout,newTaskFragment);
        fragmentTransaction.commit();


    }

    public void onSaveTask(View v){
        recyclerViewFragment.addTask(newTaskFragment.getTask());
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.remove(newTaskFragment);
        fragmentTransaction.commit();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout,recyclerViewFragment);
        fragmentTransaction.commit();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Task task=(Task)data.getSerializableExtra(Activity2.TASK_KEY);
            tasks.add(task);
           // initRecyclerView(tasks);
        }
    }

    @Override
    public void clickOnTask(int taskId) {
        Log.d("TaskManagerLog","task id: "+taskId);
        Intent intent=new Intent(this,Activity3.class);
        intent.putExtra(Activity2.TASK_KEY, (Serializable)tasks.get(taskId));
        startActivity(intent);
    }
}
