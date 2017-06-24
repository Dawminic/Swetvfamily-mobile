package com.swetvfamily.connect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alternate_login extends AppCompatActivity {

    private static EditText userEmail;
    private static EditText userPassword;
    private static Button loginButton;
    int attempts = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternate_login);
        LoginButton();
    }

    public void LoginButton() {
        userEmail = (EditText)findViewById(R.id.emailEditText);
        userPassword = (EditText)findViewById(R.id.passwordEditText);
        loginButton = (Button)findViewById(R.id.loginButton);

        loginButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (userEmail.getText().toString().equals("user@example.com") &&
                                userPassword.getText().toString().equals("pass")) {
                            Toast.makeText(alternate_login.this, "Email and Password is correct.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.swetvfamily.connect.LoginActivity");
                            startActivity(intent);

                        }
                        else{
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

}
