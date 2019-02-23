package com.example.taskmanager.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskmanager.R;
import com.example.taskmanager.models.Task;
import com.example.taskmanager.viewholder.TaskViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder>  {

    ArrayList<Task> tasks;

    public TaskAdapter(ArrayList<Task> tasks){
        this.tasks=tasks;

    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.view_holder_task,viewGroup,false);
        TaskViewHolder vh=new TaskViewHolder(v);
        Log.d("TaskManagerLog","created "+i);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {
        Log.d("TaskManagerLog","Size of list: " +String.valueOf( tasks.size()));
        Log.d("TaskManagerLog","onBind "+i);
        taskViewHolder.onBind(tasks.get(i%tasks.size()));
    }

    @Override
    public int getItemCount() {
        return 999999;
    }
}
