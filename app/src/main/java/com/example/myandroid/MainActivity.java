package com.example.myandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CustomConstraintLayout.SetTextListener, CustomTextView.SetTextListener {

    CustomConstraintLayout constraintLayout;
    CustomTextView touchConsumingTextView;
    CustomTextView touchNotConsumingTextView;
    TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.activity_layout);
        touchConsumingTextView = findViewById(R.id.touch_not_consuming_textView);
        touchNotConsumingTextView = findViewById(R.id.touch_consuming_textView);
        outputTextView = findViewById(R.id.output_text);

        constraintLayout.setListener(this);
        touchConsumingTextView.setListener(this);
        touchNotConsumingTextView.setListener(this);

        touchNotConsumingTextView.shouldConsumeTouchEvent(true);
    }

    public void setText(String text) {
        outputTextView.append(text + "\n");
    }

    public void clearText() {
        outputTextView.setText("");
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:
                setText("MainActivity -- dispatchTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "MainActivity -- dispatchTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                setText("MainActivity -- dispatchTouchEvent -- ACTION_UP");
                Log.d("develop-", "MainActivity -- dispatchTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                setText("MainActivity -- dispatchTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "MainActivity -- dispatchTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                setText("MainActivity -- dispatchTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "MainActivity -- dispatchTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.dispatchTouchEvent(ev);
        setText("MainActivity -- dispatchTouchEvent -- end = " + b);
        setText("------------------------------------------------        \n");
        Log.d("develop-", "MainActivity -- dispatchTouchEvent -- end = " + b);

        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                setText("MainActivity -- onTouchEvent -- ACTION_DOWN");
                Log.d("develop-", "MainActivity -- onTouchEvent -- ACTION_DOWN");
                break;


            case MotionEvent.ACTION_UP:
                setText("MainActivity -- onTouchEvent -- ACTION_UP");
                Log.d("develop-", "MainActivity -- onTouchEvent -- ACTION_UP");
                break;

            case MotionEvent.ACTION_MOVE:
                setText("MainActivity -- onTouchEvent -- ACTION_MOVE");
                Log.d("develop-", "MainActivity -- onTouchEvent -- ACTION_MOVE");
                break;

            case MotionEvent.ACTION_CANCEL:
                setText("MainActivity -- onTouchEvent -- ACTION_CANCEL");
                Log.d("develop-", "MainActivity -- onTouchEvent -- ACTION_CANCEL");
                break;
        }

        boolean b = super.onTouchEvent(event);
        setText("MainActivity -- onTouchEvent -- end = " + b);
        Log.d("develop-", "MainActivity -- onTouchEvent -- end = " + b);
        return b;
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear_text_button) {
            // do something here
            clearText();
        }
        return super.onOptionsItemSelected(item);
    }
}
