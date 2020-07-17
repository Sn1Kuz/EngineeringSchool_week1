package com.example.engineering_school_week1_homework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Reverse_Count_act extends AppCompatActivity {


    @BindView(R.id.count) TextView count;
    int cnt = 11;
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reverse__count_act);
        ButterKnife.bind(this);

        handler = new Handler(){
            public void handleMessage(@NonNull Message msg){
                super.handleMessage(msg);
                if(msg.what == 0) {
                    count.setText("" + msg.arg1);
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 10; i>0; i--){
                    cnt--;
                    Message msg = handler.obtainMessage();
                    msg.arg1 = cnt;
                    handler.sendMessage(msg);
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

//        그냥 스레드 버젼 Handler X
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 11; i>1; i--){
//                    cnt--;
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            count.setText(""+cnt);
//                        }
//                    });
//                    try{
//                        Thread.sleep(1000);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//                count.setText("Clear");
//                count.setTextColor(Color.parseColor("#FF0033"));
//            }
//        }).start();
    }
}