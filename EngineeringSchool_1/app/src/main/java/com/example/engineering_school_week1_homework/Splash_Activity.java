package com.example.engineering_school_week1_homework;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {

    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(Splash_Activity.this, Example_Login.class);
                startActivity(intent);
                finish();
            }
        }
        ).start();
    }
}
