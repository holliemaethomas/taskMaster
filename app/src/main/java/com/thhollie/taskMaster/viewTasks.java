package com.thhollie.taskMaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class viewTasks extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

    Button returnHome = findViewById(R.id.returnToHomeBtn);
    returnHome.setOnClickListener(v -> finish());



    }


}