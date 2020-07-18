package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    private final String TAG = "디버그";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d(TAG, "-------------- onCreate -------------");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "-------------- onStart -------------");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG, "-------------- onResume -------------");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "-------------- onPause -------------");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "-------------- onStop -------------");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "-------------- onRestart -------------");
    }
    protected void  onDestroy(){
        super.onDestroy();
        Log.d(TAG, "-------------- onDestroy -------------");
    }
}
