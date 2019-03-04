package com.example.taskmanager.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.taskmanager.R;
import com.example.taskmanager.activities.MainActivity;
import com.example.taskmanager.adapters.TaskAdapter;
import com.example.taskmanager.interfaces.IOnClickListener;
import com.example.taskmanager.models.Task;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IOnClickListener {
    RecyclerView recyclerViewTasks;
    RecyclerView.LayoutManager recycleLayoutManager;
    TaskAdapter taskAdapter;
    Button buttonAddTask;
    ArrayList<Task> tasks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        recyclerViewTasks= (RecyclerView) view.findViewById(R.id.recyclerTasks);
        recycleLayoutManager=new LinearLayoutManager(getActivity());
        recyclerViewTasks.setLayoutManager(recycleLayoutManager);

        tasks=setTasks();
        taskAdapter=new TaskAdapter(tasks,this  );
        recyclerViewTasks.setAdapter(taskAdapter);

        recyclerViewTasks.setItemAnimator(new DefaultItemAnimator());

        return view;
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

    @Override
    public void clickOnTask(int taskId) {

    }
}
