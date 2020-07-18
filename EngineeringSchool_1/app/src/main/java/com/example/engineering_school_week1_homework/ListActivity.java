package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ArrayList<SampleData> dataList;
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.InitializeMovieData();
        ListView listView = (ListView) findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this,dataList);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getText(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    public void InitializeMovieData()
    {
        dataList = new ArrayList<SampleData>();
//        for (int i = 0; i < 10; i++)
//            dataList.add(new SampleData("Text" + i));
        dataList.add(new SampleData("010-2465-1287", R.drawable.call, "Kim Yena"));
        dataList.add(new SampleData("010-3215-1578", R.drawable.call, "King SaeJong"));
        dataList.add(new SampleData("010-1248-2348", R.drawable.call, "Son SunMyeong"));
        dataList.add(new SampleData("010-1111-2222", R.drawable.call, "Lee ChanHO"));
        dataList.add(new SampleData("010-1110-2354", R.drawable.call, "So URF"));
        dataList.add(new SampleData("010-1374-7887", R.drawable.call, "Faker Lee"));
        dataList.add(new SampleData("010-1357-8942", R.drawable.call, "Jae Hun"));
        dataList.add(new SampleData("010-4648-4645", R.drawable.call, "HY3D"));
        dataList.add(new SampleData("010-6457-1254", R.drawable.call, "Erica moon"));
        dataList.add(new SampleData("010-7434-9734", R.drawable.call, "Kim J1Nu"));
        dataList.add(new SampleData("010-7895-4532", R.drawable.call, "Mun SaeHo"));
        dataList.add(new SampleData("010-1298-5578", R.drawable.call, "Lee JongSu"));
        dataList.add(new SampleData("010-4690-1287", R.drawable.call, "Kim JiWon"));
        dataList.add(new SampleData("010-7255-3466", R.drawable.call, "Ko NamKill"));
        dataList.add(new SampleData("010-4691-1287", R.drawable.call, "Kim KunHa"));
        dataList.add(new SampleData("010-2531-4690", R.drawable.call, "Lee SiBin"));

    }
    public class SampleData {
        private String text;
        private int img;
        private String name;

        public SampleData(String text, int img, String name){
            this.text = text;
            this.img = img;
            this.name = name;
        }
        public String getText()
        {
            return this.text;
        }
        public int getImg()
        {
            return this.img;
        }
        public String getName()
        {
            return this.name;
        }
    }
    public class MyAdapter extends BaseAdapter {
        Context mContext = null;
        LayoutInflater mLayoutInflater = null;
        ArrayList<SampleData> sample;
        public MyAdapter(Context context, ArrayList<SampleData> data) {
            mContext = context;
            sample = data;
            mLayoutInflater = LayoutInflater.from(mContext);
        }
        @Override
        public int getCount() {
            return sample.size();
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public SampleData getItem(int position) {
            return sample.get(position);
        }

        //view 1개씩 주는거
        //convertview - 리스트가 엄청 많아지면 getView 일일히 하며 부담이 큰데, inflate로 coverView null이면 조정
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mLayoutInflater.inflate(R.layout.layout_listview, null);
            TextView textView = (TextView)view.findViewById(R.id.textView);
            ImageView imageView = (ImageView)view.findViewById(R.id.poster);
            TextView nameView = (TextView)view.findViewById(R.id.nameView);

            textView.setText(sample.get(position).getText());
            imageView.setImageResource(sample.get(position).getImg());
            nameView.setText(sample.get(position).getName());

            return view;
        }
    }
}