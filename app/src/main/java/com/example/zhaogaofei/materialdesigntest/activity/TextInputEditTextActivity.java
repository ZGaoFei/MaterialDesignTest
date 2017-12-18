package com.example.zhaogaofei.materialdesigntest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhaogaofei.materialdesigntest.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInputEditTextActivity extends AppCompatActivity implements View.OnClickListener {
    // matcher email
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

    private TextInputLayout layoutOne;
    private TextInputLayout layoutTwo;

    public static void start(Context context) {
        context.startActivity(new Intent(context, TextInputEditTextActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_edit_text);

        initView();
    }

    private void initView() {
        layoutOne = (TextInputLayout) findViewById(R.id.text_input_one);
        layoutTwo = (TextInputLayout) findViewById(R.id.text_input_two);
        Button button = (Button) findViewById(R.id.button_login);

        layoutOne.setHint("Name");
        layoutTwo.setHint("Password");

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                onLogin();
                break;
        }
    }

    private void onLogin() {
        hideKeyboard();

        String name = layoutOne.getEditText().getText().toString().trim();
        String password = layoutTwo.getEditText().getText().toString().trim();

        if (!validateEmail(name)) {
            layoutOne.setError("Not a valid email address!");
        } else if (!validatePassword(password)) {
            layoutTwo.setError("Not a valid password!");
        } else {
            layoutOne.setErrorEnabled(false);
            layoutTwo.setErrorEnabled(false);
            doLogin();
        }
    }

    /**
     * hide keyboard
     */
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        return password.length() >= 6;
    }

    private void doLogin() {
        Toast.makeText(this, "Do login!!!", Toast.LENGTH_SHORT).show();
    }
}
