package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Example_Login extends AppCompatActivity {

    Button login_btn;
    Intent intent;
    EditText ID, PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example__login);

        login_btn = (Button) findViewById(R.id.login_btn);

        //PassWord부분 글자 치면 *로 만들기
        PW = (EditText) findViewById(R.id.password);
        PW.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

        login_btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                intent = new Intent(Example_Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //EditText EnterKey Stop
        PW.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_ENTER){
                    return true;
                }
                return false;
            }
        });
    }
}