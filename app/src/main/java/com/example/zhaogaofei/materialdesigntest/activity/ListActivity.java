package com.example.zhaogaofei.materialdesigntest.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhaogaofei.materialdesigntest.R;
import com.example.zhaogaofei.materialdesigntest.adapter.ListTableAdapter;
import com.example.zhaogaofei.materialdesigntest.config.Config;
import com.example.zhaogaofei.materialdesigntest.config.ConfigModel;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    private ListTableAdapter adapter;

    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton actionButton;
    private ImageView imageView;
    private Toolbar toolbar;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        initData();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListTableAdapter(this);
        recyclerView.setAdapter(adapter);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        actionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);
        actionButton.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.image_view_list_header);
        toolbar = (Toolbar) findViewById(R.id.tool_bar_list);
    }

    private void initData() {
        Glide.with(this)
                .load(Config.IMAGE8)
                .override(500, 300)
                .crossFade(1000)
                .into(imageView);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Material Design Test");

        List<ConfigModel> list = new ArrayList<>();
        list.add(new ConfigModel(Config.IMAGE0, Config.TEXT0));
        list.add(new ConfigModel(Config.IMAGE1, Config.TEXT1));
        list.add(new ConfigModel(Config.IMAGE2, Config.TEXT2));
        list.add(new ConfigModel(Config.IMAGE3, Config.TEXT3));
        list.add(new ConfigModel(Config.IMAGE4, Config.TEXT4));
        list.add(new ConfigModel(Config.IMAGE5, Config.TEXT5));
        list.add(new ConfigModel(Config.IMAGE6, Config.TEXT6));
        list.add(new ConfigModel(Config.IMAGE7, Config.TEXT7));

        adapter.setData(list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floating_action_button:
                showSnackBar("hello world!!!");
                break;
            default:
                break;
        }
    }

    private void showSnackBar(String text) {
        Snackbar.make(coordinatorLayout, text, Snackbar.LENGTH_SHORT).show();
    }
}
