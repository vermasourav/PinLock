package com.verma.mobile.android.pinlock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textView = (TextView) findViewById(R.id.text);
        String code = getIntent().getStringExtra("code");
        textView.setText(String.format("The true code is: %s", code));
    }
}
