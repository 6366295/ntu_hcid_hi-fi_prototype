package com.hcid.edulearn.asksimple;

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
import android.widget.ImageView;
import android.widget.TextView;

public class LiveSessionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livesession);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

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
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.slidingmenu_settings, menu);
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

        if (id == R.id.nav_courses) {
            Intent intent = new Intent(this, CoursesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ask_question(View view) {

    }

    public void go_to_the_question(View view) {

    }

    public void click_1(View view) {
        TextView tv = (TextView) findViewById(R.id.textView1);
        ImageView iv = (ImageView) findViewById(R.id.imageView1);
        if(tv.getText() == "29"){
            iv.setImageResource(R.drawable.like);
            tv.setText("30");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("29");
        }
    }

    public void click_2(View view) {
        TextView tv = (TextView) findViewById(R.id.textView2);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        if(tv.getText() == "3"){
            iv.setImageResource(R.drawable.like);
            tv.setText("4");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("3");
        }
    }

    public void click_3(View view) {
        TextView tv = (TextView) findViewById(R.id.textView3);
        ImageView iv = (ImageView) findViewById(R.id.imageView3);
        if(tv.getText() == "16"){
            iv.setImageResource(R.drawable.like);
            tv.setText("17");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("16");
        }
    }

    public void click_4(View view) {
        TextView tv = (TextView) findViewById(R.id.textView4);
        ImageView iv = (ImageView) findViewById(R.id.imageView4);
        if(tv.getText() == "0"){
            iv.setImageResource(R.drawable.like);
            tv.setText("1");
        }else{
            iv.setImageResource(R.drawable.not_like);
            tv.setText("0");
        }
    }
}
