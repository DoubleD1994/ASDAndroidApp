package com.example.daviddryburgh.asdandroidapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import static android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS;

/**
 * Created by daviddryburgh on 01/11/2017.
 */

public class Brightness extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);

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

        Button light_brightness = (Button) findViewById(R.id.highBrightness);
        Button med_brightness = (Button) findViewById(R.id.medBrightness);
        Button dark_brightness = (Button) findViewById(R.id.darkBrightness);

        light_brightness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = 1;
                getWindow().setAttributes(layoutParams);
            }
        });

        med_brightness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = (float)0.5;
                getWindow().setAttributes(layoutParams);
            }
        });

        dark_brightness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                layoutParams.screenBrightness = 0;
                getWindow().setAttributes(layoutParams);
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
            Intent searchIntent = new Intent(Brightness.this, MainActivity.class);
            startActivity(searchIntent);
        } else if(id == R.id.geolocation){
            Intent searchIntent = new Intent(Brightness.this, Geolocation.class);
            startActivity(searchIntent);
        } else if(id == R.id.camera){
            Intent searchIntent = new Intent(Brightness.this, Camera.class);
            startActivity(searchIntent);
        } else if(id == R.id.calendar){
            Intent searchIntent = new Intent(Brightness.this, Calendar.class);
            startActivity(searchIntent);
        } else if(id == R.id.brightness){
            Intent searchIntent = new Intent(Brightness.this, Brightness.class);
            startActivity(searchIntent);
        } else if(id == R.id.flashlight){
            Intent searchIntent = new Intent(Brightness.this, Flashlight.class);
            startActivity(searchIntent);
        } else if(id == R.id.vibration){
            Intent searchIntent = new Intent(Brightness.this, Vibration.class);
            startActivity(searchIntent);
        } else if(id == R.id.screen_orientation){
            Intent searchIntent = new Intent(Brightness.this, ScreenOrientation.class);
            startActivity(searchIntent);
        } else if(id == R.id.notifications){
            Intent searchIntent = new Intent(Brightness.this, Notifications.class);
            startActivity(searchIntent);
        } else if(id == R.id.social_sharing){
            Intent searchIntent = new Intent(Brightness.this, SocialSharing.class);
            startActivity(searchIntent);
        } else if(id == R.id.screenshot){
            Intent searchIntent = new Intent(Brightness.this, Screenshot.class);
            startActivity(searchIntent);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
