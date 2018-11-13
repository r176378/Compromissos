package br.unicamp.ft.r176378_f171258.compromissos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        fragmentManager = getSupportFragmentManager();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenCompromissos screenCompromissos = new ScreenCompromissos();
        ftrans.replace(R.id.mainContainer, screenCompromissos, "screenCompromissos");
        ftrans.addToBackStack("screenCompromissos");
        ftrans.commit();
        mFragmentTransaction = fragmentManager.beginTransaction();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    private void screenNewCompromisso() {
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenNewCompromisso screenNewCompromisso = new ScreenNewCompromisso();
        ftrans.replace(R.id.mainContainer, screenNewCompromisso, "screenNewCompromissos");
        ftrans.addToBackStack("screenNewCompromissos");
        ftrans.commit();
    }

    private void screenCalendar() {
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenCalendar screenCalendar = new ScreenCalendar();
        ftrans.replace(R.id.mainContainer, screenCalendar, "screenCalendar");
        ftrans.addToBackStack("screenCalendar");
        ftrans.commit();
    }

    private void screenCompromissos() {
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ScreenCompromissos screenCompromissos = new ScreenCompromissos();
        ftrans.replace(R.id.mainContainer, screenCompromissos, "screenCompromissos");
        ftrans.addToBackStack("screenCompromissos");
        ftrans.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            screenCompromissos();
        } else if (id == R.id.nav_gallery) {
            screenCalendar();
        } else if (id == R.id.nav_new) {
        screenNewCompromisso();
    }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
