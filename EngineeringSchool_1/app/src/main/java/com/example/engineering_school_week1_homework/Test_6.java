package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Test_6 extends AppCompatActivity {

    TextView text;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_6);

        text = (TextView) findViewById(R.id.text);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                text.setText("Tracking Start");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text.setText("Tracking Finsih");
            }
        });
    }
}
