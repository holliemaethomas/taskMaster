package com.thhollie.taskMaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Grab the save button
        View save = findViewById(R.id.save);
        View savedChanges = findViewById(R.id.savedChanges);


        //Set up Shared Preferences & Editor
        SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = p.edit();

        //Set up on click listener
        save.setOnClickListener((v) -> {
            //Get the input text
            EditText t = findViewById(R.id.username);

            //Grab the selected RadioButton
            RadioGroup group = (RadioGroup) findViewById(R.id.setGroup);
            int radioId = group.getCheckedRadioButtonId();
            RadioButton selected = group.findViewById(radioId);
            String team = selected.getText().toString();

            //Save it to SharedPreferences
            edit.putString("user", t.getText().toString());
            edit.putString("team", team);
            edit.apply();

            //Return message that settings were saved
            savedChanges.setVisibility(View.VISIBLE);
        });
    }
}
