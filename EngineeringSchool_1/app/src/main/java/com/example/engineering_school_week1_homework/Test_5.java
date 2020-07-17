package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.AsyncTask;


public class Test_5 extends AppCompatActivity {

    Button btn;
    ProgressBar progressBar;
    EditText editText;
    int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_5);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button);

    }
    public void Click(View v){
        value = Integer.parseInt(editText.getText().toString());
        progressBar.setProgress(value);
    }
}
