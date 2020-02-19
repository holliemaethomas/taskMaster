package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class appSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);


        Button saveUsername = findViewById(R.id.saveSettingButton);
        saveUsername.setOnClickListener(v -> {
            TextInputEditText newUsername = findViewById(R.id.userName);
            String username = newUsername.getText().toString();

            SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = p.edit();
            editor.putString("username", username);
            editor.apply();
            Intent newUsernameIntent = new Intent(appSettings.this, MainActivity.class);
            appSettings.this.startActivity(newUsernameIntent);
        });


    }
}