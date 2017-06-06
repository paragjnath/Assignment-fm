package com.fancymonk.fancymonk.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fancymonk.fancymonk.R;

public class LoginActivity extends AppCompatActivity {

    private Button mSignUpButton;
    private Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);

            }
        });

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ConfirmActivity.class);
                startActivity(intent);

            }
        });
    }
}
