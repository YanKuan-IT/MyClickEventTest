package com.example.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {
    // 上次点击的坐标
    private int mLastX, mLastY;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 内部拦截法
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 当前点击的坐标
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                // 请求父容器不要进行拦截
                // 父容器中，已经设置down事件不拦截，这里为什么还要再设置一次不拦截？
                // 因为，当down事件的时候，父布局不会进行拦截，但move时间的时候，会返回true，拦截
                // 这里再次设置，当viewGroup中调用dispatchTouchEvent方法中
                // final boolean disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
                // 就不会再去调用 onInterceptTouchEvent 方法了，如果调用了，move事件，父容器就会拦截了。
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                // x轴移动的距离
                int deltaX = x - mLastX;
                // y轴移动的距离
                int deltaY = y - mLastY;
                // 如果x轴移动距离 大于 y轴，说明是左右移
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    // 左右移，是viewPager进行处理的，即父容器，即需要父容器进行拦截，这里进行调用设置
                    // 上下移动，不需要处理，即自己就可以处理了
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;

        return super.dispatchTouchEvent(ev);
    }
}
