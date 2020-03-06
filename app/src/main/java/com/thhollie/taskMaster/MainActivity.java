package com.thhollie.taskMaster;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.amplify.generated.graphql.ListTasksQuery;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserState;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;


public class MainActivity extends AppCompatActivity implements MyTaskRecyclerViewAdapter.OnTaskClickedListener {

    private static final String TAG = "Rachael";
    private AWSAppSyncClient mAWSAppSyncClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Grab the buttons
        View b1 = findViewById(R.id.button1);
        View b2 = findViewById(R.id.button2);


        View set = findViewById(R.id.settings);

        //Set up the event listeners
        b1.setOnClickListener((v) -> {
            Intent i = new Intent(this, AddTask.class);
            startActivity(i);
        });

        b2.setOnClickListener((v) -> {
            Intent i = new Intent(this, AllTasks.class);
            startActivity(i);
        });

        set.setOnClickListener((v) -> {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
        });

        View logout = findViewById(R.id.logout);
        logout.setOnClickListener((v) -> {
            String username = AWSMobileClient.getInstance().getUsername();
            AWSMobileClient.getInstance().signOut();

            AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

                        @Override
                        public void onResult(UserStateDetails userStateDetails) {
                            Log.i("INIT", "onResult: " + userStateDetails.getUserState());
                            if (userStateDetails.getUserState().equals(UserState.SIGNED_OUT)) {
                                AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {

                                    @Override
                                    public void onResult(UserStateDetails result) {
                                        Log.d(TAG, "onResult: " + result.getUserState());

                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Log.e(TAG, "onError: ", e);
                                    }
                                });
                            }
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("INIT", "Initialization error.", e);
                        }
                    }
            );

        });

        //TODO Put this code into a method
        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

                    @Override
                    public void onResult(UserStateDetails userStateDetails) {
                        Log.i("INIT", "onResult: " + userStateDetails.getUserState());
                        if (userStateDetails.getUserState().equals(UserState.SIGNED_OUT)) {
                            AWSMobileClient.getInstance().showSignIn(MainActivity.this, new Callback<UserStateDetails>() {

                                @Override
                                public void onResult(UserStateDetails result) {
                                    Log.d(TAG, "onResult: " + result.getUserState());

                                }

                                @Override
                                public void onError(Exception e) {
                                    Log.e(TAG, "onError: ", e);
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("INIT", "Initialization error.", e);
                    }
                }
        );

    }


    @Override
    public void onResume() {
        super.onResume();

        TextView user = findViewById(R.id.userTasks);

        String username = AWSMobileClient.getInstance().getUsername();
        user.setText(username + "'s Tasks");
    }

    @Override
    public void taskClicked(ListTasksQuery.Item t) {
        Intent i = new Intent(this, TaskDetail.class);
        i.putExtra("title", t.title());
        i.putExtra("details", t.body());
        i.putExtra("state", t.taskState());
        startActivity(i);

    }
}