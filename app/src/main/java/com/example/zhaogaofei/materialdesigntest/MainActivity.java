package com.example.zhaogaofei.materialdesigntest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.materialdesigntest.activity.ConstraintLayoutActivity;
import com.example.zhaogaofei.materialdesigntest.activity.TextInputEditTextActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOne = (Button) findViewById(R.id.button_one);
        btOne.setOnClickListener(this);
        Button btTwo = (Button) findViewById(R.id.button_two);
        btTwo.setOnClickListener(this);
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
        }
    }
}
