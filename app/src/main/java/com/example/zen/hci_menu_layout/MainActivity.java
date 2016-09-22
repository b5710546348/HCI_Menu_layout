package com.example.zen.hci_menu_layout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    TextView assignment_noti,new_feeds_noti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendarView.setMinDate(calendar1.getTimeInMillis());
        calendarView.setMaxDate(calendar2.getTimeInMillis());



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        assignment_noti =(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_assignment));

        new_feeds_noti =(TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_new_feeds));


        String[] x = new String[]{"AAA","BBB","CCC"};
        ListView lv = (ListView) findViewById(R.id.mobile_list);
        ArrayAdapter<String> test = new ArrayAdapter<>(this, R.layout.app_bar_main,x);
        //lv.setAdapter(test);

       initializeCountDrawer();
    }

    private void initializeCountDrawer(){

        assignment_noti.setGravity(Gravity.CENTER_VERTICAL);
        assignment_noti.setTypeface(null, Typeface.BOLD);
        assignment_noti.setTextColor(getResources().getColor(R.color.colorAccent));
        assignment_noti.setText("3");

        new_feeds_noti.setGravity(Gravity.CENTER_VERTICAL);
        new_feeds_noti.setTypeface(null, Typeface.BOLD);
        new_feeds_noti.setTextColor(getResources().getColor(R.color.colorAccent));
        new_feeds_noti.setText("20+");

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
