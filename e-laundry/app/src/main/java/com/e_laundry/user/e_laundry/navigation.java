package com.e_laundry.user.e_laundry;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import org.json.JSONArray;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /*Button logout;
    SessionManager session;
    TextView status;
    JSONArray contacts = null;
    String email, nama, id;*/

    private ViewFlipper viewFlipper;
    private Animation fadeIn, fadeOut;
    private ImageView CuciMamel, CuciKering, CuciSetrika, Status, DetailLaundry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");
        CuciMamel = (ImageView) findViewById(R.id.imCMamel);
        CuciKering = (ImageView) findViewById(R.id.imCKering);
        CuciSetrika = (ImageView) findViewById(R.id.imCSetrika);
        Status = (ImageView) findViewById(R.id.imContact);
        DetailLaundry = (ImageView) findViewById(R.id.imAbout);



        CuciMamel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlamat = new Intent(getApplicationContext(), alamat.class);
                startActivity(intentAlamat);
            }

        });

        CuciKering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlamat = new Intent(getApplicationContext(), alamat.class);
                startActivity(intentAlamat);
            }
        });


        CuciSetrika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenAlamat = new Intent(getApplicationContext(), alamat.class);
                startActivity(intenAlamat);
            }
        });

        DetailLaundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenAlamat = new Intent(getApplicationContext(), detail_pesanan.class);
                startActivity(intenAlamat);
            }
        });

        Status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenAlamat = new Intent(getApplicationContext(), proses.class);
                startActivity(intenAlamat);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        viewFlipper.setInAnimation(fadeIn);
        viewFlipper.setOutAnimation(fadeOut);

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intenthome = new Intent(getApplicationContext(), navigation.class);
            startActivity(intenthome);


            // Handle the home action
        } else if (id == R.id.nav_profil) {

            Intent intentprofil = new Intent(getApplicationContext(), Profil.class);
            startActivity(intentprofil);

        } else if (id == R.id.nav_contact) {

            Intent intentContact = new Intent(getApplicationContext(), kontak.class);
            startActivity(intentContact);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
