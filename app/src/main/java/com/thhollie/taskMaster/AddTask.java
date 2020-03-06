package com.thhollie.taskMaster;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.amazonaws.amplify.generated.graphql.CreateTaskMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import javax.annotation.Nonnull;

import type.CreateTaskInput;


public class AddTask extends AppCompatActivity {

    private AWSAppSyncClient mAWSAppSyncClient;
    private static String TAG = "rnr.catch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        View submit = findViewById(R.id.submit);
        View addImage = findViewById(R.id.addImage);

        addImage.setOnClickListener((v) -> {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            } else {
                startActivityForResult(i, 777);
            }
        });


        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();

        submit.setOnClickListener((v) -> {
            final TextView submitted = findViewById(R.id.submittedMsg);
            submitted.setVisibility(View.VISIBLE);

            EditText taskTitle = findViewById(R.id.editText2);
            EditText taskDetails = findViewById(R.id.editText);

            String title = taskTitle.getText().toString();
            String details = taskDetails.getText().toString();

            RadioGroup group = (RadioGroup) findViewById(R.id.addGroup);
            int radioId = group.getCheckedRadioButtonId();
            RadioButton selected = group.findViewById(radioId);
            String team = selected.getText().toString();


            CreateTaskInput input = CreateTaskInput.builder()
                    .title(title)
                    .body(details)
                    .taskState("new")
                    .taskTeamId(team)
                    .build();

            mAWSAppSyncClient.mutate(CreateTaskMutation.builder().input(input).build()).enqueue(
                    new GraphQLCall.Callback<CreateTaskMutation.Data>() {
                        @Override
                        public void onResponse(@Nonnull Response<CreateTaskMutation.Data> response) {
                            Log.i(TAG, response.data().toString());
                        }

                        @Override
                        public void onFailure(@Nonnull ApolloException e) {
                            Log.w(TAG, "failure");
                        }
                    });
        });
    }


}
