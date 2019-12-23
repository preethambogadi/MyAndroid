package com.example.myandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomConstraintLayout extends ConstraintLayout {
    private SetTextListener setTextListener;
    public CustomConstraintLayout(Context context) {
        super(context);
    }

    public CustomConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListener(SetTextListener setTextListener) {
        this.setTextListener = setTextListener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                setTextListener.setText("  ConstraintLay -- dispatchTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "  ConstraintLay -- dispatchTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                setTextListener.setText("  ConstraintLay -- dispatchTouchEvent -- ACTION_UP");
                Log.d("develop-", "  ConstraintLay -- dispatchTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                setTextListener.setText("  ConstraintLay -- dispatchTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "  ConstraintLay -- dispatchTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                setTextListener.setText("  ConstraintLay -- dispatchTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "  ConstraintLay -- dispatchTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.dispatchTouchEvent(ev);
        setTextListener.setText("  ConstraintLay -- dispatchTouchEvent -- end = " + b);
        Log.d("develop-", "  ConstraintLay -- dispatchTouchEvent -- end = " + b);
        return b;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                setTextListener.setText("  ConstraintLay -- onInterceptTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "  ConstraintLay -- onInterceptTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                setTextListener.setText("  ConstraintLay -- onInterceptTouchEvent -- ACTION_UP");
                Log.d("develop-", "  ConstraintLay -- onInterceptTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                setTextListener.setText("  ConstraintLay -- onInterceptTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "  ConstraintLay -- onInterceptTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                setTextListener.setText("  ConstraintLay -- onInterceptTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "  ConstraintLay -- onInterceptTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.onInterceptTouchEvent(ev);
        setTextListener.setText("  ConstraintLay -- onInterceptTouchEvent -- end = " + b);
        Log.d("develop-", "  ConstraintLay -- onInterceptTouchEvent -- end = " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                setTextListener.setText("  ConstraintLay -- onTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "  ConstraintLay -- onTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                setTextListener.setText("  ConstraintLay -- onTouchEvent -- ACTION_UP");
                Log.d("develop-", "  ConstraintLay -- onTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                setTextListener.setText("  ConstraintLay -- onTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "  ConstraintLay -- onTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                setTextListener.setText("  ConstraintLay -- onTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "  ConstraintLay -- onTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.onTouchEvent(event);
        setTextListener.setText("  ConstraintLay -- onTouchEvent -- end = " + b);
        Log.d("develop-", "  ConstraintLay -- onTouchEvent -- end = " + b);
        return b;
    }

    interface SetTextListener {
        void setText(String text);
    }
}
