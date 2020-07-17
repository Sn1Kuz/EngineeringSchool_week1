package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Frame_Layout extends AppCompatActivity {

    Button up, down;
    boolean one=false, two = false;
    ImageView img1, img2, img3, img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame__layout);

        up = (Button) findViewById(R.id.up);
        down = (Button)findViewById(R.id.down);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img1_2);
        img4 = (ImageView) findViewById(R.id.img2_2);
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.up:
                        if(one){
                            img1.setVisibility(View.INVISIBLE);
                            img2.setVisibility(View.VISIBLE);
                            one =!one;
                        }
                        else{
                            img1.setVisibility(View.VISIBLE);
                            img2.setVisibility(View.INVISIBLE);
                            one =!one;
                        }
                        break;
                    case R.id.down:
                        if(two){
                            img3.setVisibility(View.VISIBLE);
                            img4.setVisibility(View.INVISIBLE);
                            two =!two;
                        }
                        else{
                            img3.setVisibility(View.INVISIBLE);
                            img4.setVisibility(View.VISIBLE);
                            two =!two;
                        }
                        break;

                }
//                if(yes){
//                    img1.setVisibility(View.INVISIBLE);
//                    img2.setVisibility(View.VISIBLE);
//                    yes = !yes;
//                }
//                else{
//                    img2.setVisibility(View.INVISIBLE);
//                    img1.setVisibility(View.VISIBLE);
//                    yes = !yes;
//                }
            }
        };

        up.setOnClickListener(onClickListener);
        down.setOnClickListener(onClickListener);
    }
}
