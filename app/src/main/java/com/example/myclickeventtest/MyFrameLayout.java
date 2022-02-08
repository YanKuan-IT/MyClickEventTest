package com.example.myclickeventtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyFrameLayout extends FrameLayout {
    private static final String TAG = "AAAAAA";
    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }
    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyFrameLayout: dispatchTouchEvent ------");
        boolean flag = super.dispatchTouchEvent(ev);
        Log.d(TAG, "MyFrameLayout: dispatchTouchEvent, return: " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyFrameLayout: onTouchEvent ------");
        boolean flag = super.onTouchEvent(event);
        Log.d(TAG, "MyFrameLayout: onTouchEvent, return: " + flag);
        return flag;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyFrameLayout: onInterceptTouchEvent ------");
        boolean flag = super.onInterceptTouchEvent(ev);
//        flag = true;
        Log.d(TAG, "MyFrameLayout: onInterceptTouchEvent, return: " + flag);
        return flag;
    }
}
