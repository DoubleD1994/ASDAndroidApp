package com.example.daviddryburgh.asdandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Vibrator;

/**
 * Created by daviddryburgh on 01/11/2017.
 */

public class Vibration extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button vibrate_once = (Button) findViewById(R.id.vibrate_once);
        Button vibrate_pause = (Button) findViewById(R.id.vibrate_pause);

        vibrate_once.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                // Vibrate for 2 Seconds
                vibrator.vibrate(2000);

            }
        });

        vibrate_pause.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                long pattern[] = {0, 1000, 1000, 1000};

                // Vibrate, pause, vibrate
                vibrator.vibrate(pattern, -1);

            }
        });
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
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent searchIntent = new Intent(Vibration.this, MainActivity.class);
            startActivity(searchIntent);
        } else if(id == R.id.geolocation){
            Intent searchIntent = new Intent(Vibration.this, Geolocation.class);
            startActivity(searchIntent);
        } else if(id == R.id.camera){
            Intent searchIntent = new Intent(Vibration.this, Camera.class);
            startActivity(searchIntent);
        } else if(id == R.id.calendar){
            Intent searchIntent = new Intent(Vibration.this, Calendar.class);
            startActivity(searchIntent);
        } else if(id == R.id.brightness){
            Intent searchIntent = new Intent(Vibration.this, Brightness.class);
            startActivity(searchIntent);
        } else if(id == R.id.flashlight){
            Intent searchIntent = new Intent(Vibration.this, Flashlight.class);
            startActivity(searchIntent);
        } else if(id == R.id.vibration){
            Intent searchIntent = new Intent(Vibration.this, Vibration.class);
            startActivity(searchIntent);
        } else if(id == R.id.screen_orientation){
            Intent searchIntent = new Intent(Vibration.this, ScreenOrientation.class);
            startActivity(searchIntent);
        } else if(id == R.id.notifications){
            Intent searchIntent = new Intent(Vibration.this, Notifications.class);
            startActivity(searchIntent);
        } else if(id == R.id.social_sharing){
            Intent searchIntent = new Intent(Vibration.this, SocialSharing.class);
            startActivity(searchIntent);
        } else if(id == R.id.screenshot){
            Intent searchIntent = new Intent(Vibration.this, Screenshot.class);
            startActivity(searchIntent);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
