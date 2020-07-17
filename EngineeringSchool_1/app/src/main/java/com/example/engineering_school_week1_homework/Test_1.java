package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test_1 extends Activity {


    //MultiAutoCompleteTextView Field
    private static String[] AUTO_ITEM = {"Apple", "Black", "Nerd", "Geek", "Game", "Google", "LOL", "Naver","Kakao"};

    TextView note;
    Button next, before;
    int page = 0;

    int text_end = 4;

    private static String[] text = {"멀티 자동완성 텍스트뷰는 사용자 입력을 자동으로 완성해주는 TextView이다.\n멀티 자동완성 텍스트뷰는 자동 완성 텍스트뷰와 한 가지 차이점을 제외하고는 동일하다.\n1.여러 개의 단어 완성(여러 단어가 가능 단어1, 단어2, ...)\n토크나이저 설정 필요(CommaTokenizer:쉼표로 단어들을 구분)",
            "자동완성과 멀티 자동완성은 한개의 단어냐, 여러 개의 단어냐 차이이다.(G를 치면 Game, Google 등이 한꺼번에 뜬다)\n그래서 멀티 자동완성 텍스트뷰는 자동완성 텍스트뷰를 기반으로 만들어졌다.\n자바 lang에서 View, TextView, AutoCompleteTextView 아래에 있다.",
            "지금 이 파일에 코드와 같이 미리 String[]에 단어를 넣어놓고, setAdapter로 설정을 하면 끝이다.\nMulti에 에 가장 큰 중요점은 바로 Tokenizer이다. 이 코드의 기능으로 인해 여러단어를 구분하여 매번 자동완성 리스트가 보여질 수 있다, 현재는 단어를 콤마(,)로만 구분할 수 있는 토크나이저를 제공하고 있고, 다른 문자를 사용하고 싶다면 직접 만들어서 사용하면 된다.",
            "코드에 ArrayAdapter의 android.R.layout_simple_dropdown_item_1line은 문자열들을 보여주는 리스트 모양이며, 뒤에 배열은 화면에 보여질 문자열들을 가지고 있는 문자열 배열이다.\nxml에 completionThreshold는 몇번째 단어부터 완성을 할 것이냐를 지정하느 것이다. 즉 저것이 =2로 설정되어 있다면 만약 Apple을 찾는다면 ap까지 총 2글자가 작성되어야지 자동완성이 뜬다.",
    "-참고-\nhttps://kairo96.gitbooks.io/android/ch3.14.html"};


    //CheckedTextView Field
    CheckedTextView monsterball, superball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_1);


        //About MultiAutoCompleteTextView
        MultiAutoCompleteTextView AutoText = (MultiAutoCompleteTextView)findViewById(R.id.AutoText);
        AutoText.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, AUTO_ITEM));
        AutoText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        next = (Button) findViewById(R.id.Next);
        before = (Button) findViewById(R.id.Before);
        note = (TextView) findViewById(R.id.what_is_MulitiAutoCompleteTextView);
        note.setText(text[page]);


        //About CheckedTextView
        monsterball = (CheckedTextView) findViewById(R.id.monsterball_check);
        superball = (CheckedTextView) findViewById(R.id.superball_check);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Next:
                        if (page == text_end) break;
                        page++;
                        note.setText(text[page]);
                        break;
                    case R.id.Before:
                        if (page == 0 ) break;
                        page--;
                        note.setText(text[page]);
                        break;
                    case R.id.monsterball_check:
                        if(monsterball.isChecked()){
                            note.setText("몬스터볼X");
                            monsterball.setChecked(false);
                        }
                        else{
                            note.setText("몬스터볼 !");
                            monsterball.setChecked(true);
                        }
                        break;
                    case R.id.superball_check:
                        if(superball.isChecked()){
                            note.setText("슈퍼볼X");
                            superball.setChecked(false);
                        }
                        else{
                            note.setText("SetCheckedBox는 기존 Text에 체크박스를 넣은것.xml파일에 listChoiceIndicator____는 체크박스 모양차이인 것으로 추정됨(네모, 동그라미인 상태)\nDrawable + 방향으로 사진도 넣을 수 있는데 크기 조절은 xml에서 바로 수정은 안됨. 수정하려면 다른 xml파일 만들어서 크기를 조정하거나 애초에 작은 사진을 넣어야 할 듯");
                            superball.setChecked(true);
                        }
                        break;
                }
            }
        };

        next.setOnClickListener(onClickListener);
        before.setOnClickListener(onClickListener);
        monsterball.setOnClickListener(onClickListener);
        superball.setOnClickListener(onClickListener);
    }
}