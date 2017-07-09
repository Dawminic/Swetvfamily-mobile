package com.swetvfamily.connect;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class CameraAndSocialClubStream extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static GestureDetectorCompat detector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_and_social_club_stream);
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
            Intent swipeToMap = new Intent(this, MapActivity.class);
            startActivity(swipeToMap);
            return true;
        }
        //If user swipes left
        else if (diffX < 0){
            Intent swipeToFeedsAndChats = new Intent(this, FeedsAndChats.class);
            startActivity(swipeToFeedsAndChats);
            return true;
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
