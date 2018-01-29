package com.example.zhaogaofei.materialdesigntest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.materialdesigntest.activity.ConstraintLayoutActivity;
import com.example.zhaogaofei.materialdesigntest.activity.ListActivity;
import com.example.zhaogaofei.materialdesigntest.activity.TextInputEditTextActivity;
import com.example.zhaogaofei.materialdesigntest.activity.ToolBarTestActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close);*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                R.string.open, R.string.close); // 不带home图标

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button btOne = (Button) findViewById(R.id.button_one);
        btOne.setOnClickListener(this);
        Button btTwo = (Button) findViewById(R.id.button_two);
        btTwo.setOnClickListener(this);
        Button btThree = (Button) findViewById(R.id.button_three);
        btThree.setOnClickListener(this);
        Button btFour = (Button) findViewById(R.id.button_four);
        btFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                ConstraintLayoutActivity.start(this);
                break;
            case R.id.button_two:
                TextInputEditTextActivity.start(this);
                break;
            case R.id.button_three:
                ListActivity.start(this);
                break;
            case R.id.button_four:
                ToolBarTestActivity.start(this);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
