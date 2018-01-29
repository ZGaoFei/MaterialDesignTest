package com.example.zhaogaofei.materialdesigntest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.zhaogaofei.materialdesigntest.R;

public class ToolBarTestActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, View.OnClickListener {

    private Toolbar toolbar;
    private SwitchCompat switchCompat;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ToolBarTestActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_test);

        toolbar = (Toolbar) findViewById(R.id.tool_bar_test);

        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("Tool Bar");
        toolbar.setSubtitle("Test");
        toolbar.setOnMenuItemClickListener(this);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher_round);

        switchCompat = (SwitchCompat) findViewById(R.id.switch_compat);
        switchCompat.setChecked(true);
        switchCompat.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        boolean checked = switchCompat.isChecked();
        Toast.makeText(this, checked + "", Toast.LENGTH_SHORT).show();
    }
}
