package com.swetvfamily.connect;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class AvatarProfileActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_profile);
        detector = new GestureDetectorCompat(this, this);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //Create intent for swipe activity to open up the map screen
        //Check to see if user swiping left or right
        float diffX = e2.getX() - e1.getX();
        //If user swipes left
        if (diffX < 0) {
            Intent swipeToMap = new Intent(this, MapActivity.class);
            startActivity(swipeToMap);
            return true;
        }
        //If user swipes right
        else {
            return false;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
