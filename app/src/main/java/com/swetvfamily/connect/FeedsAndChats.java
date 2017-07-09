package com.swetvfamily.connect;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class FeedsAndChats extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds_and_chats);
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
        //Create intent for swipe activity to open up the avatar profile screen
        //Check to see if user swiping left or right
        float diffX = e2.getX() - e1.getX();
        //If user swipes right
        if (diffX > 0) {
            Intent swipeToCamera = new Intent(this, CameraAndSocialClubStream.class);
            startActivity(swipeToCamera);
            return true;
        }
        //If user swipes left
        else if (diffX < 0){
            return false;
        }

        else{
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
