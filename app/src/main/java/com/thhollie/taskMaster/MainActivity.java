package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ThHollie.main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addTask = findViewById(R.id.goToAddTaskBtn);
        addTask.setOnClickListener((v) -> {
            Intent addToTaskList = new Intent(MainActivity.this, addTask.class);
            MainActivity.this.startActivity(addToTaskList);
        });

        Button viewTaskList = findViewById(R.id.viewTasks);
        viewTaskList.setOnClickListener((v) -> {
            Intent showTaskList = new Intent(MainActivity.this, viewTasks.class);
            MainActivity.this.startActivity(showTaskList);
        });
    }
}