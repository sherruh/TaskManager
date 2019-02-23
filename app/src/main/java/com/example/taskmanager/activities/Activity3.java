package com.example.taskmanager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskmanager.R;
import com.example.taskmanager.models.Task;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Activity3 extends AppCompatActivity {

    TextView taskTitle;
    TextView taskDescription;
    ImageView taskImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Intent intent=getIntent();
        Task task=(Task) intent.getSerializableExtra(Activity2.TASK_KEY);
        taskTitle=findViewById(R.id.task_title_text_view_opened);
        taskDescription=findViewById(R.id.task_description_text_view_opened);
        taskImage=findViewById(R.id.imageView_opened);
        initViewTask(task);
    }

    private void initViewTask(Task task) {
        taskTitle.setText(task.getTitle());
        taskDescription.setText(task.getDecriprion());
        Picasso.get().load("http://i.imgur.com/"+ String.valueOf(task.getImageId())+".jpg").
                resize(1000, 1000)
                .centerCrop().into(taskImage);
    }
}
