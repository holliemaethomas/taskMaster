package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

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

        Button appSettings = findViewById(R.id.appSettingsButton);
        appSettings.setOnClickListener((v) -> {
            Intent goToSettingsActivity = new Intent(MainActivity.this, com.thhollie.taskMaster.appSettings.class);
            MainActivity.this.startActivity(goToSettingsActivity);
        });

        Button taskDetails = findViewById(R.id.taskDetailsButton);
        taskDetails.setOnClickListener((v) -> {
            Intent viewTaskDetails = new Intent(MainActivity.this, com.thhollie.taskMaster.taskDetails.class);
            MainActivity.this.startActivity(viewTaskDetails);
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences userLoggedIn = PreferenceManager.getDefaultSharedPreferences(this);
        String userID = userLoggedIn.getString("username", "default");
        TextView headerTask = findViewById(R.id.mainHeader);
        headerTask.setText(userID);
    }



}