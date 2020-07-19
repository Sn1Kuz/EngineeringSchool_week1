package com.example.engineering_school_week1_homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView listview = null ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyAdapter adapter;

        // Adapter 생성
        adapter = new MyAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);


        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Sam Smith", "010-2498-1254\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Kim Kunha", "010-2498-1254\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Si jae", "010-2498-1254\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Faker", "010-2498-1254\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Ruler", "010-2498-1254\r\n") ;
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.call),
                "Sam Smith", "010-2498-1254\r\n") ;


        //search name, number ... by Filter
        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                if (filterText.length() > 0) {
                    listview.setFilterText(filterText) ;
                } else {
                    listview.clearTextFilter() ;
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;
    }
    public void InitializeMovieData()
    {
//        dataList = new ArrayList<SampleData>();
//        for (int i = 0; i < 10; i++)
//            dataList.add(new SampleData("Text" + i));
//        dataList.add(new SampleData("010-2465-1287", R.drawable.call, "Kim Yena"));
//        dataList.add(new SampleData("010-3215-1578", R.drawable.call, "King SaeJong"));
//        dataList.add(new SampleData("010-1248-2348", R.drawable.call, "Son SunMyeong"));
//        dataList.add(new SampleData("010-1111-2222", R.drawable.call, "Lee ChanHO"));
//        dataList.add(new SampleData("010-1110-2354", R.drawable.call, "So URF"));
//        dataList.add(new SampleData("010-1374-7887", R.drawable.call, "Faker Lee"));
//        dataList.add(new SampleData("010-1357-8942", R.drawable.call, "Jae Hun"));
//        dataList.add(new SampleData("010-4648-4645", R.drawable.call, "HY3D"));
//        dataList.add(new SampleData("010-6457-1254", R.drawable.call, "Erica moon"));
//        dataList.add(new SampleData("010-7434-9734", R.drawable.call, "Kim J1Nu"));
//        dataList.add(new SampleData("010-7895-4532", R.drawable.call, "Mun SaeHo"));
//        dataList.add(new SampleData("010-1298-5578", R.drawable.call, "Lee JongSu"));
//        dataList.add(new SampleData("010-4690-1287", R.drawable.call, "Kim JiWon"));
//        dataList.add(new SampleData("010-7255-3466", R.drawable.call, "Ko NamKill"));
//        dataList.add(new SampleData("010-4691-1287", R.drawable.call, "Kim KunHa"));
//        dataList.add(new SampleData("010-2531-4690", R.drawable.call, "Lee SiBin"));
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


//    public class MyAdapter extends BaseAdapter implements Filterable {
////        Context mContext = null;
////        LayoutInflater mLayoutInflater = null;
//        ArrayList<SampleData> sample;
//        ArrayList<SampleData> filteredSample = sample;
//
//        Filter listFilter;
//        private int position;
//        private View convertView;
//        private ViewGroup parent;
//
//        public MyAdapter() { //Context context, ArrayList<SampleData> data
////            mContext = context;
////            sample = data;
////            mLayoutInflater = LayoutInflater.from(mContext);
//        }
//        @Override
//        public int getCount() {
//            return sample.size();
//        }
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//        @Override
//        public SampleData getItem(int position) {
//            return filteredSample.get(position);
//        }
//
//        //view 1개씩 주는거
//        //convertview - 리스트가 엄청 많아지면 getView 일일히 하며 부담이 큰데, inflate로 coverView null이면 조정
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            final int pos = position;
//            final  Context context = parent.getContext();
//
//            if(convertView == null){
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.layout_listview, parent, false);
//            }
//            TextView textView = (TextView)convertView.findViewById(R.id.textView);
//            ImageView imageView = (ImageView)convertView.findViewById(R.id.poster);
//            TextView nameView = (TextView)convertView.findViewById(R.id.nameView);
//
//            SampleData sampleDataitem = filteredSample.get(position);
//
//            textView.setText(sampleDataitem.getText());
//            imageView.setImageResource(sampleDataitem.getImg());
//            nameView.setText(sampleDataitem.getName());
//
//            return convertView;
//        }
//
//        //About Filter
//        @Override
//        public Filter getFilter() {
//            if(listFilter == null){
//                listFilter = new ListFilter();
//            }
//            return listFilter;
//        }
//
//        private class ListFilter extends Filter{
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                FilterResults results = new FilterResults();
//
//                if(constraint == null || constraint.length() == 0){
//                    results.values = sample;
//                    results.count = sample.size();
//                } else{
//                    ArrayList<SampleData> itemList = new ArrayList<SampleData>();
//
//                    for(SampleData item : sample){
//                        if(item.getName().toUpperCase().contains(constraint.toString().toUpperCase())||
//                        item.getText().toUpperCase().contains(constraint.toString().toUpperCase()))
//                        {
//                            itemList.add(item);
//                        }
//                    }
//                    results.values = itemList;
//                    results.count = itemList.size();
//                }
//                return results;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//
//                //Update Listview by filtered data list
//                filteredSample = (ArrayList<SampleData>) results.values;
//
//                if(results.count > 0){
//                    notifyDataSetChanged();
//                } else{
//                    notifyDataSetInvalidated();
//                }
//            }
//        }
//    }
}