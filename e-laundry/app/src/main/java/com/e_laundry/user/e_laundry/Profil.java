package com.e_laundry.user.e_laundry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.e_laundry.user.e_laundry.sharedpref.SharedPref;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final Button bLogout = (Button) findViewById(R.id.bLogout);
        final Button bUpdate = (Button) findViewById(R.id.bUpdate);

        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPref.getInstance(getApplicationContext()).logout();
                Intent bLogout = new Intent(getApplicationContext(), login.class);
                startActivity(bLogout);
            }
        });

        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bUpdate = new Intent(getApplicationContext(), navigation.class);
                startActivity(bUpdate);
            }
        });
    }
}
