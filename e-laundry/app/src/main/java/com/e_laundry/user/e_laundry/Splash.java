package com.e_laundry.user.e_laundry;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.e_laundry.user.e_laundry.sharedpref.SharedPref;

public class Splash extends Activity {

    private static int SPLASH_TIME_OUT = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SharedPref.getInstance(getApplicationContext()).isLoggedIn()) {
                    Intent iCekEmail = new Intent(getApplicationContext(), navigation.class);
                    startActivity(iCekEmail);
                    finish();
                } else {
                    Intent iCekEmail = new Intent(getApplicationContext(), login.class);
                    startActivity(iCekEmail);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}