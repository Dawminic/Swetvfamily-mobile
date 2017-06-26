package com.swetvfamily.connect;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alternate_login extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private static EditText userEmail;
    private static EditText userPassword;
    private static Button loginButton;
    private static GestureDetectorCompat detector;
    int attempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_login);
        LoginButton();

        detector = new GestureDetectorCompat(this, this);
    }

    public void LoginButton() {
        userEmail = (EditText)findViewById(R.id.emailEditText);
        userPassword = (EditText)findViewById(R.id.passwordEditText);
        loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (userEmail.getText().toString().equals("user@example.com") && userPassword.getText().toString().equals("pass")) {
                        Toast.makeText(alternate_login.this, "Email and Password is correct.",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("com.swetvfamily.connect.LoginActivity");
                        startActivity(intent);

                    }
                    else {
                        Toast.makeText(alternate_login.this, "Email and Password is not a correct combination.",Toast.LENGTH_SHORT).show();
                        attempts--;

                        if (attempts ==  0){
                            loginButton.setEnabled(false);
                        }
                    }

                }
            }
        );
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
        Intent swipeToMap = new Intent(this, MapActivity.class);
        startActivity(swipeToMap);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
