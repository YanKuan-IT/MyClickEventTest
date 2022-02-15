package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private int[] imageViewArr = new int[] {
            R.drawable.pic0,
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewPager myViewPager = findViewById(R.id.my_view_pager);

        List<Map<String, Integer>> mList = new ArrayList<>();
        Map<String, Integer> map;
        for (int i=0; i<9; i++){
            map = new HashMap<>();
            map.put("key", imageViewArr[i % 9]);
            mList.add(map);
        }

        MyPagerAdapter adapter = new MyPagerAdapter(this, mList);
        myViewPager.setAdapter(adapter);
    }
}