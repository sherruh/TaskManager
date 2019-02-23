package com.example.taskmanager.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskmanager.R;
import com.example.taskmanager.models.Task;
import com.squareup.picasso.Picasso;

public class TaskViewHolder extends RecyclerView.ViewHolder  {
    TextView taskTitle;
    TextView taskDescription;
    ImageView taskImage;
    int taskId;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskTitle=itemView.findViewById(R.id.vh_task_Title);
        taskDescription=itemView.findViewById(R.id.textOfTask);
        taskImage=itemView.findViewById(R.id.imageView);
    }

    public void onBind(Task task){
        taskDescription.setText(task.getDecriprion());
        taskTitle.setText(task.getTitle());
        Picasso.get().load("http://i.imgur.com/"+ String.valueOf(task.getImageId())+".jpg").
                resize(150, 150)
                .centerCrop().into(taskImage);

        Log.d("TaskManagerLog","Image URL:  http://i.imgur.com/"+
                String.valueOf(task.getImageId())+".jpg");
        taskId= task.getTaskId();

    }
}
