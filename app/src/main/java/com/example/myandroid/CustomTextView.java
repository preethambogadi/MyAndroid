package com.example.myandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {

    private SetTextListener textListener;
    private boolean shouldConsumeTouch = false;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListener(CustomConstraintLayout.SetTextListener setTextListener) {
        this.textListener = (SetTextListener) setTextListener;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                textListener.setText("    CustomTextView -- dispatchTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "    CustomTextView -- dispatchTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                textListener.setText("    CustomTextView -- dispatchTouchEvent -- ACTION_UP");
                Log.d("develop-", "    CustomTextView -- dispatchTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                textListener.setText("    CustomTextView -- dispatchTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "    CustomTextView -- dispatchTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                textListener.setText("    CustomTextView -- dispatchTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "    CustomTextView -- dispatchTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.dispatchTouchEvent(event);
        textListener.setText("    CustomTextView -- dispatchTouchEvent -- end = " + b);
        Log.d("develop-", "    CustomTextView -- dispatchTouchEvent -- end = " + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                textListener.setText("    CustomTextView -- onTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "    CustomTextView -- onTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                textListener.setText("    CustomTextView -- onTouchEvent -- ACTION_UP");
                Log.d("develop-", "    CustomTextView -- onTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                textListener.setText("    CustomTextView -- onTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "    CustomTextView -- onTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                textListener.setText("    CustomTextView -- onTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "    CustomTextView -- onTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.onTouchEvent(event);
        textListener.setText("    CustomTextView -- onTouchEvent -- end = " + b);
        Log.d("develop-", "    CustomTextView -- onTouchEvent -- end = " + b);
        return shouldConsumeTouch;
    }

    public void shouldConsumeTouchEvent(boolean consumeTouch) {
        this.shouldConsumeTouch = consumeTouch;
    }

    interface SetTextListener {
        void setText(String text);
    }
}
