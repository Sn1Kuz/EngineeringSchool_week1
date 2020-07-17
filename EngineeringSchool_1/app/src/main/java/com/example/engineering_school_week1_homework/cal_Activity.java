package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cal_Activity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, div, times, remainder, point, AllClear, changeProperty, equal;
    TextView result;

    double a = 0;
    boolean current_op = false;
    int last_operator = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_);

        result = (TextView) findViewById(R.id.result);

        //0~9 num
        zero = (Button) findViewById(R.id.btn13);
        one = (Button) findViewById(R.id.btn10);
        two = (Button) findViewById(R.id.btn11);
        three = (Button) findViewById(R.id.btn12);
        four = (Button) findViewById(R.id.btn7);
        five = (Button) findViewById(R.id.btn8);
        six = (Button) findViewById(R.id.btn9);
        seven = (Button) findViewById(R.id.btn4);
        eight = (Button) findViewById(R.id.btn5);
        nine = (Button) findViewById(R.id.btn6);

        plus = (Button) findViewById(R.id.btn19);
        minus = (Button) findViewById(R.id.btn18);
        times = (Button) findViewById(R.id.btn17);
        div = (Button) findViewById(R.id.btn16);
        remainder = (Button) findViewById(R.id.btn3);
        point = (Button) findViewById(R.id.btn15);
        AllClear = (Button) findViewById(R.id.btn1);
        changeProperty = (Button) findViewById(R.id.btn2);
        equal = (Button) findViewById(R.id.btn20);


        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn13:
                        result.setText(result.getText().toString() + 0);
                        break;
                    case R.id.btn10:
                        result.setText(result.getText().toString() + 1);
                        break;
                    case R.id.btn11:
                        result.setText(result.getText().toString() + 2);
                        break;
                    case R.id.btn12:
                        result.setText(result.getText().toString() + 3);
                        break;
                    case R.id.btn7:
                        result.setText(result.getText().toString() + 4);
                        break;
                    case R.id.btn8:
                        result.setText(result.getText().toString() + 5);
                        break;
                    case R.id.btn9:
                        result.setText(result.getText().toString() + 6);
                        break;
                    case R.id.btn4:
                        result.setText(result.getText().toString() + 7);
                        break;
                    case R.id.btn5:
                        result.setText(result.getText().toString() + 8);
                        break;
                    case R.id.btn6:
                        result.setText(result.getText().toString() + 9);
                        break;

                    case R.id.btn15:
                        result.setText(result.getText().toString() + ".");
                        break;

                    case R.id.btn19:
                        if (!current_op) {
                            a = Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 1;
                            current_op = true;
                        } else {
                            a += Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 1;
                        }
                        break;
                    case R.id.btn18:
                        if (!current_op) {
                            a = Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 2;
                            current_op = true;
                        } else {
                            a -= Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 2;
                        }
                        break;
                    case R.id.btn17:
                        if (!current_op) {
                            a = Double.parseDouble(result.getText().toString());
                            result.setText("");
                            current_op = true;
                            last_operator = 3;
                        } else {
                            a *= Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 3;
                        }
                        break;
                    case R.id.btn16:
                        if (!current_op) {
                            a = Double.parseDouble(result.getText().toString());
                            result.setText("");
                            current_op = true;
                            last_operator = 4;
                        } else {
                            a /= Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 4;
                        }
                        break;
                    case R.id.btn3:
                        if (!current_op) {
                            a = Double.parseDouble(result.getText().toString());
                            result.setText("");
                            current_op = true;
                            last_operator = 5;
                        } else {
                            a %= Double.parseDouble(result.getText().toString());
                            result.setText("");
                            last_operator = 5;
                        }
                        break;
                    case R.id.btn1:
                        a = 0;
                        result.setText("");
                        current_op = false;
                        break;
                    case R.id.btn2:
                        String num = result.getText().toString();
                        if (num.charAt(0) == '-') {
                            result.setText(num.substring(1));
                        } else {
                            result.setText('-' + num);
                        }
                        break;
                    case R.id.btn20:
                        switch (last_operator) {
                            case 1:
                                a += Double.parseDouble(result.getText().toString());
                                break;
                            case 2:
                                a -= Double.parseDouble(result.getText().toString());
                                break;
                            case 3:
                                a *= Double.parseDouble(result.getText().toString());
                                break;
                            case 4:
                                a /= Double.parseDouble(result.getText().toString());
                                break;
                            case 5:
                                a %= Double.parseDouble(result.getText().toString());
                                break;
                        }
                        result.setText(Double.toString(a));
                        current_op = false;
                        last_operator = 0;
                        break;
                }
            }
        };

        zero.setOnClickListener(onClickListener);
        one.setOnClickListener(onClickListener);
        two.setOnClickListener(onClickListener);
        three.setOnClickListener(onClickListener);
        four.setOnClickListener(onClickListener);
        five.setOnClickListener(onClickListener);
        six.setOnClickListener(onClickListener);
        seven.setOnClickListener(onClickListener);
        eight.setOnClickListener(onClickListener);
        nine.setOnClickListener(onClickListener);
        point.setOnClickListener(onClickListener);
        plus.setOnClickListener(onClickListener);
        minus.setOnClickListener(onClickListener);
        div.setOnClickListener(onClickListener);
        times.setOnClickListener(onClickListener);
        remainder.setOnClickListener(onClickListener);
        AllClear.setOnClickListener(onClickListener);
        changeProperty.setOnClickListener(onClickListener);
        equal.setOnClickListener(onClickListener);
    }
}
