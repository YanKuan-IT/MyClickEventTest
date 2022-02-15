package com.example.mylistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import java.util.Map;

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<Map<String, Integer>> mData;

    public MyPagerAdapter(Context mContext, List<Map<String, Integer>> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.item_list, null);
        ListView list = view.findViewById(R.id.my_list_view);
        list.setAdapter(new SimpleAdapter(
                        container.getContext(),
                        mData,
                        R.layout.item_base,
                        new String[]{"key"},
                        new int[]{R.id.image_view}
                        )
        );

        container.addView(view);

//        return super.instantiateItem(container, position);
        return view;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return false;
        return view == object;
    }
}
