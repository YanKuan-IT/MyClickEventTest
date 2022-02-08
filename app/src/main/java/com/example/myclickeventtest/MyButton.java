package com.example.myclickeventtest;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {
    private static final String TAG = "AAAAAA";
    public MyButton(Context context) {
        super(context);
    }
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyButton: dispatchTouchEvent ------");
//        return super.dispatchTouchEvent(event);

        boolean flag = super.dispatchTouchEvent(event);
        Log.d(TAG, "MyButton: dispatchTouchEvent, return: " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "MyButton: onTouchEvent ------");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "MyButton: onTouchEvent: MotionEvent.ACTION_DOWN = " + MotionEvent.ACTION_DOWN);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "MyButton: onTouchEvent: MotionEvent.ACTION_MOVE = " + MotionEvent.ACTION_MOVE);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "MyButton: onTouchEvent: MotionEvent.ACTION_UP = " + MotionEvent.ACTION_UP);
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "MyButton: onTouchEvent: MotionEvent.ACTION_CANCEL = " + MotionEvent.ACTION_CANCEL);
                break;
        }
        boolean flag = super.onTouchEvent(event);
        Log.d(TAG, "MyButton: onTouchEvent, return: " + flag);
        return flag;
    }
}
