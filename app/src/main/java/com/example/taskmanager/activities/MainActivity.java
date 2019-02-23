package com.example.taskmanager.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.taskmanager.R;
import com.example.taskmanager.adapters.TaskAdapter;
import com.example.taskmanager.interfaces.IOnClickListener;
import com.example.taskmanager.models.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IOnClickListener {

    RecyclerView recyclerViewTasks;
    RecyclerView.LayoutManager recycleLayoutManager;
    TaskAdapter taskAdapter;
    Button buttonAddTask;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks=setTasks();
        initRecyclerView(tasks);
        buttonAddTask=findViewById(R.id.add_tsk_bth);
        taskAdapter=new TaskAdapter(tasks,this);
    }

    private ArrayList<Task> setTasks() {
        ArrayList<Task> tasks=new ArrayList<>();
        tasks.add(new Task("Task 1","Text of task",1));
        tasks.add(new Task("Task 2","Text of task",2));
        tasks.add(new Task("Task 3","Text of task",3));
        //tasks.add(new Task("Task 4","Text of task",4));
        //tasks.add(new Task("Task 5","Text of task",5));
        //tasks.add(new Task("Task 6","Text of task",6));
        //tasks.add(new Task("Task 7","Text of task",7));
        //tasks.add(new Task("Task 8","Text of task",8));
        //tasks.add(new Task("Task 9","Text of task",9));
        //tasks.add(new Task("Task 10","Text of task",10));
        //tasks.add(new Task("Task 11","Text of task",11));
        //tasks.add(new Task("Task 12","Text of task",12));
        //tasks.add(new Task("Task 13","Text of task",13));
        //tasks.add(new Task("Task 14","Text of task",14));
        //tasks.add(new Task("Task 15","Text of task",15));
        //tasks.add(new Task("Task 16","Text of task",16));
        //tasks.add(new Task("Task 17","Text of task",17));
        //tasks.add(new Task("Task 18","Text of task",18));
        //tasks.add(new Task("Task 19","Text of task",19));
        //tasks.add(new Task("Task 20","Text of task",20));
        return tasks;
    }

    private void initRecyclerView(ArrayList<Task> tasks) {//TODO приходится вызывать метод после закрытия Activity2
        recyclerViewTasks=findViewById(R.id.recyclerTasks);
        recycleLayoutManager=new LinearLayoutManager(this);
        taskAdapter=new TaskAdapter(tasks,this);
        recyclerViewTasks=findViewById(R.id.recyclerTasks);
        recyclerViewTasks.setAdapter(taskAdapter);
        recyclerViewTasks.setLayoutManager(recycleLayoutManager);
    }

    public void addNewTask(View v){
        Intent intent=new Intent(this, Activity2.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Task task=(Task)data.getSerializableExtra(Activity2.TASK_KEY);
            tasks.add(task);
            initRecyclerView(tasks);
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
