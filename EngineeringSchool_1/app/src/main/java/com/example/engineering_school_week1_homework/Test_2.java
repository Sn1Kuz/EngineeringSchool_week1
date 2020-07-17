package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Test_2 extends AppCompatActivity {



    TextView note, downnote;
    Button next, before, downNext, downBefore;
    int page = 0;
    int down_page = 0;

    int text_end = 4;
    int down_text_end = 6;

    private String[] text = {"TextInputLayout은 TextInputEditText에 입력된 텍스트에 반응하는 레이아웃으로, EditText의 상위버전이라 할 수 있다.\nbulid.gradle파일에 dependencises의 머터리얼 라이브러리를 implementaion해야 사용가능하다.",
            "자신이 사용할 레이아웃에 TextInputLayout태그와 그 안에 TextInputEditText 태그를 추가해주면 준비는 끝난다.",
    "-Error Message 나타내기-\nTextInputLayout에 errorEnabled 태그를 추가하고(app:error...에서 app부분 import해주고/true는 error키고, false는 끄는 기능) 그 후 액티비티에서 error를 어떤 조건에서 나타낼지 지정하면된다.",
    "현재 코드에서는 getEditText() 메서드로 TextInputLayout에서 editText를 찾고, 그 editText를 addTextChangedListner->TextWatcher를 오버라이딩해서 사용했다.",
    "beforeTextChanged는 입력하기 전에 호출되는 API이며, onTextChanged는 EditText에 변화가 있을 때, afterTextChanged는 입력이 끝 났을 때의 이벤트이다."};


    private String[] AboutTextView = {"-About TextView-\nTextView가 화면에 출력될 때, 기본적으로 단순한 텍스트 형태이지만, 속성을 사용함으로써 다양한 모양과 기능을 가지게 만들 수 있으며, palette에 password, number등이 이러한 속성이 이미 첨가되어 있는 것들이다.",
    "TextView의 속성은 다른 View 위젯에 비하여 많은 편이며, View로부터 상속받은 속성을 제외하고도 약 70개가 되나, \n자주 사용되는 속성은 그리 많지 않기 때문에 필요할 때마다 찾아서 쓰면 된다.",
    "autoLink와 같이 링크 형태로 사용하거나 autoText와 같이 자동 오타 수정 기능 사용, 텍스트에 커서가 보일지, \n입력 가능한 문자 제한하기, 텍스트 기준으로 특정 위치에 이미지 출력하기, gravity-TextView의 텍스트 정렬 방식 지정 등이 있다."
    ,"여기서 inputType으로 전화번호, Passwd?등 텍스트 입력기에 입력가능한 데이터 유형, 방법, 기능 지정이 가능하고 \n이게 palette에 대부분 같다. EditText, AutoCompleteTextView등도 이러한 속성을 사용하여 지정해둔 방식이다."
    ,"TextView는 EditTExt와 Button의 부모 클래스로, 텍스트를 표시하기 위한 용도로 만들어진 TextView, 텍스트를 입력받아 화면에 표시하기 위한 EditText, 텍스트/이미지를 출력한 다음, 사용자로부터의 터치 입력을 처리하기 위한 Button. 이 3가지 View위젯의 공통점은 텍스트를 출력하는 기능을 가진다."
    ,"특히 API Level3에서 'editable(입력가능 여부 지정)'속성을 포함한 텍스트 편집 관련 속성들이 deprecated되기 전에는 TextView의 속성들을 사용하여 EditText가 가진 거의 대부분의 기능을제공할 수 있었다는 것을 상기할 필요가 있습니다. 이는 TextView와 EditText의 속성에 대한 경계가 모호하다는 것을 의미합니다."
    ,"링크 - https://recipes4dev.tistory.com/70"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_2);

        note = findViewById(R.id.explainText);
        note.setText(text[0]);
        next = findViewById(R.id.Next);
        before = findViewById(R.id.Before);
        downnote = findViewById(R.id.AboutText);
        downnote.setText(AboutTextView[0]);
        downBefore = findViewById(R.id.down_before);
        downNext = findViewById(R.id.down_next);

        //About TextInputLayout
        final TextInputLayout inputLayout = findViewById(R.id.TextInputLayout);
        inputLayout.setCounterEnabled(true);
        inputLayout.setCounterMaxLength(10);


        final EditText editText = inputLayout.getEditText();//getEditText method로 editText불를 수 있음

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length()<10){
                    editText.setTextColor(Color.BLACK);
                }else {
                    editText.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().contains("#")){
                    inputLayout.setError("특수 문자는 사용할 수 없습니다");
                }
                else{
                    inputLayout.setError(null);
                }
            }
        });


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
                    case R.id.down_next:
                        if(down_page == down_text_end)break;
                        down_page++;
                        downnote.setText(AboutTextView[down_page]);
                        break;
                    case R.id.down_before:
                        if(down_page == 0)break;
                        down_page--;
                        downnote.setText(AboutTextView[down_page]);
                        break;
                }
            }
        };

        next.setOnClickListener(onClickListener);
        before.setOnClickListener(onClickListener);
        downNext.setOnClickListener(onClickListener);
        downBefore.setOnClickListener(onClickListener);

    }
}
