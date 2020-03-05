package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        String taskTitle = getIntent().getStringExtra("title");
        TextView pageTitle = findViewById(R.id.taskName);

        String taskDetails = getIntent().getStringExtra("details");
        TextView detailView = findViewById(R.id.textView8);

        String taskStatus = getIntent().getStringExtra("state");
        TextView statusView = findViewById(R.id.status);

        pageTitle.setText(taskTitle);
        detailView.setText(taskDetails);
        statusView.setText(taskStatus);
    }
}