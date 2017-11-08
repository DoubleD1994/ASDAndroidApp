package com.example.daviddryburgh.asdandroidapp;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by daviddryburgh on 01/11/2017.
 */

public class Geolocation extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {


    private GoogleMap map;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geolocation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mapView = (MapView) findViewById(R.id.map);
        MapsInitializer.initialize(Geolocation.this);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        Button get_position = (Button) findViewById(R.id.get_position);

        get_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    LocationManager locationManager = (LocationManager) Geolocation.this.getSystemService(Context.LOCATION_SERVICE);
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    LatLng initial = new LatLng(location.getLatitude(), location.getLongitude());
                    map.addMarker(new MarkerOptions().position(initial));
                    map.moveCamera(CameraUpdateFactory.newLatLng(initial));
                } catch (SecurityException e){
                    e.printStackTrace();
                }
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
            Intent searchIntent = new Intent(Geolocation.this, MainActivity.class);
            startActivity(searchIntent);
        } else if(id == R.id.geolocation){
            Intent searchIntent = new Intent(Geolocation.this, Geolocation.class);
            startActivity(searchIntent);
        } else if(id == R.id.camera){
            Intent searchIntent = new Intent(Geolocation.this, Camera.class);
            startActivity(searchIntent);
        } else if(id == R.id.calendar){
            Intent searchIntent = new Intent(Geolocation.this, Calendar.class);
            startActivity(searchIntent);
        } else if(id == R.id.brightness){
            Intent searchIntent = new Intent(Geolocation.this, Brightness.class);
            startActivity(searchIntent);
        } else if(id == R.id.flashlight){
            Intent searchIntent = new Intent(Geolocation.this, Flashlight.class);
            startActivity(searchIntent);
        } else if(id == R.id.vibration){
            Intent searchIntent = new Intent(Geolocation.this, Vibration.class);
            startActivity(searchIntent);
        } else if(id == R.id.screen_orientation){
            Intent searchIntent = new Intent(Geolocation.this, ScreenOrientation.class);
            startActivity(searchIntent);
        } else if(id == R.id.notifications){
            Intent searchIntent = new Intent(Geolocation.this, Notifications.class);
            startActivity(searchIntent);
        } else if(id == R.id.social_sharing){
            Intent searchIntent = new Intent(Geolocation.this, SocialSharing.class);
            startActivity(searchIntent);
        } else if(id == R.id.screenshot){
            Intent searchIntent = new Intent(Geolocation.this, Screenshot.class);
            startActivity(searchIntent);
        }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng initial = new LatLng(0, 0);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(initial));
        mapView.onResume();

    }
}
