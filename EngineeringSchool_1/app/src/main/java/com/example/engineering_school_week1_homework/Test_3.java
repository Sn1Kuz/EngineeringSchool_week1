package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Test_3 extends AppCompatActivity {


    TextView note;
    Button next, before;
    static String[] explain = {"-Image Button 설명-\n Button  widget이 TextView에서 상속받은 것처럼, ImageButton도 ImageView로부터 상속받는다.(현재 default, press, focused 3가지 사용)"
    ,"이미지버튼을 Layout resource XML에 추가하고, 'src'속성에 이미지를 지정하기만 하면 된다. 버튼의 상태에 따라 이미지를 선택해줄 수 있다. 상태에 따른 이미지 지정은 'selector'를 지정한 리소스 XML을 추가하여 그안에 작성하면 된다.",
    "'selector'를 사용할 때 주의할 점은 item의 순서가 결과에 영향을 미친다는 것이다. 위에서부터 item을 비교를 시작하여 현재 Button의 상태와 일치하는 아이템이 있다면 그 것을 선택한다. 또한 가장 마지막에 있는 상태 값이 사용되지 않은 item은 default상태로 사용된다."
            , "-추가내용-\n1. 버튼 위젯에서 background속성을 사용해서도 가능하다.\n2. 사진의 크기가 버튼과 알맞지 않은 경우가 많다. 이런 경우 android:adjustViewBOunds 와 adnroid:scaleType을 적절히 사용하면 해결할 수 있다."
            ,"scaleType은 ImageView의 사이즈에 맞추기 위해 어떻게 resize할지, Bound는 이미지의 가로세로 비율을 유지하기 위해 이미지뷰의 경계를 조절하는 것이다."};

    int page = 0, text_end = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_3);

        note = (TextView) findViewById(R.id.explainText);
        next = (Button) findViewById(R.id.Next);
        before = (Button)findViewById(R.id.Before);
        note.setText(explain[0]);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.Next:
                        if (page == text_end) break;
                        page++;
                        note.setText(explain[page]);
                        break;
                    case R.id.Before:
                        if (page == 0) break;
                        page--;
                        note.setText(explain[page]);
                        break;
                }
            }
        };

        next.setOnClickListener(onClickListener);
        before.setOnClickListener(onClickListener);
    }
}
