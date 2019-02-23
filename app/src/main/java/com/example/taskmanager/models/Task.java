package com.example.taskmanager.models;

import java.io.Serializable;
import java.util.Random;

public class Task implements Serializable {

    String title;
    String decriprion;
    int taskId;
    int imageId;

    public Task(String title, String decriprion, int taskImage) {
        this.title = title;
        this.decriprion = decriprion;
        //this.taskId = taskId;
        imageId=taskImage+(new Random().nextInt(99999)+10000);
    }

    public String getTitle() {
        return title;
    }

    public String getDecriprion() {
        return decriprion;
    }

    public int getTaskId() {
        return taskId;
    }

    public int getImageId() {
        return imageId;
    }
}
