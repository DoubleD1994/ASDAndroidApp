package com.example.daviddryburgh.asdandroidapp;

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
import android.widget.EditText;

/**
 * Created by daviddryburgh on 01/11/2017.
 */

public class SocialSharing extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btnShare;
    EditText the_message;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_sharing);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        btnShare = (Button) findViewById(R.id.share_message);
        the_message = (EditText) findViewById(R.id.message);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                message = the_message.getText().toString();
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "Share with: "));
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent searchIntent = new Intent(SocialSharing.this, MainActivity.class);
            startActivity(searchIntent);
        } else if(id == R.id.geolocation){
            Intent searchIntent = new Intent(SocialSharing.this, Geolocation.class);
            startActivity(searchIntent);
        } else if(id == R.id.camera){
            Intent searchIntent = new Intent(SocialSharing.this, Camera.class);
            startActivity(searchIntent);
        } else if(id == R.id.calendar){
            Intent searchIntent = new Intent(SocialSharing.this, Calendar.class);
            startActivity(searchIntent);
        } else if(id == R.id.brightness){
            Intent searchIntent = new Intent(SocialSharing.this, Brightness.class);
            startActivity(searchIntent);
        } else if(id == R.id.flashlight){
            Intent searchIntent = new Intent(SocialSharing.this, Flashlight.class);
            startActivity(searchIntent);
        } else if(id == R.id.vibration){
            Intent searchIntent = new Intent(SocialSharing.this, Vibration.class);
            startActivity(searchIntent);
        } else if(id == R.id.screen_orientation){
            Intent searchIntent = new Intent(SocialSharing.this, ScreenOrientation.class);
            startActivity(searchIntent);
        } else if(id == R.id.notifications){
            Intent searchIntent = new Intent(SocialSharing.this, Notifications.class);
            startActivity(searchIntent);
        } else if(id == R.id.social_sharing){
            Intent searchIntent = new Intent(SocialSharing.this, SocialSharing.class);
            startActivity(searchIntent);
        } else if(id == R.id.screenshot){
            Intent searchIntent = new Intent(SocialSharing.this, Screenshot.class);
            startActivity(searchIntent);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
