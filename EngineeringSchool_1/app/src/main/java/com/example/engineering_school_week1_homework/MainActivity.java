package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //    Button btn1, btn2, btn3, btn4, btn5;
    Context context = this;
    Intent intent;

    //ButterKnife로 button을 findviewById 링크?해준다는 느낌
    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;
    @BindView(R.id.btn5) Button btn5;
    @BindView(R.id.btn6) Button btn6;
    @BindView(R.id.btn7) Button btn7;
    @BindView(R.id.btn8) Button btn8;
    @BindView(R.id.btn9) Button btn9;
    @BindView(R.id.btn10) Button btn10;
    @BindView(R.id.btn11) Button btn11;
    @BindView(R.id.btn12) Button btn12;
    @BindView(R.id.btn13) Button btn13;
    @BindView(R.id.btn14) Button btn14;
    @BindView(R.id.btn15) Button btn15;
    @BindView(R.id.btn16) Button btn16;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                intent = new Intent(context, cal_Activity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(context, color_Activity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(context, Frame_Layout.class);
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(context, Reverse_Count_act.class);
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(context, Test_1.class);
                startActivity(intent);
                break;
            case R.id.btn6:
                intent = new Intent(context, Test_2.class);
                startActivity(intent);
                break;
            case R.id.btn7:
                intent = new Intent(context, Test_3.class);
                startActivity(intent);
                break;
            case R.id.btn8:
                intent = new Intent(context, Test_4.class);
                startActivity(intent);
                break;
            case R.id.btn9:
                intent = new Intent(context, Test_5.class);
                startActivity(intent);
                break;
            case R.id.btn10:
                intent = new Intent(context, Test_6.class);
                startActivity(intent);
                break;
            default:
                //이게 지금 MainActivity는 인터페이스를 상속받아서 Toast가 되는거 같음. 다른 곳에서는 안됨(Test_1은 넣었다가 지웠음)
                Toast.makeText(this, "아직 지정되지 않은 버튼입니다.",Toast.LENGTH_SHORT).show();

        }
    }
}