package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class addTask extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        Button addedTaskBtn = findViewById(R.id.addTaskBtn);
    }
    protected void returnToPrevious(View v) {
        View returnToPrevious = findViewById(R.id.returnToHomeBtn);
        this.finish();
    }
    public void showMessage(View v){
        Toast confirmToast = Toast.makeText(this, R.string.confirmed,Toast.LENGTH_LONG);
        confirmToast.show();
    }


}