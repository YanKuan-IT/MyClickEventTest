package com.example.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {

    private int mLastX, mLastY;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // 内部拦截法
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
        // 当为down事件的时候，不进行拦截，让子view，即ListView去处理即可，当为move事件等再拦截
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            super.onInterceptTouchEvent(ev);
            return false;
        }
        return true;
    }

    // 外部拦截法
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//                mLastX = (int) ev.getX();
//                mLastY = (int) ev.getY();
//                break;
//            }
//            case MotionEvent.ACTION_MOVE: {
//                int deltaX = x - mLastX;
//                int deltaY = y - mLastY;
//                if (Math.abs(deltaX) > Math.abs(deltaY)) {
//                    return true;
//                }
//                break;
//            }
//            case MotionEvent.ACTION_UP: {
//                break;
//            }
//            default:
//                break;
//        }
//
//        return super.onInterceptTouchEvent(ev);
//    }
}
