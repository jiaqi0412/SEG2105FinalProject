package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class welcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Intent intent = getIntent();
        String name = intent.getStringExtra(signUpActivity.EXTRA_TEXT);

        TextView textView1 = (TextView) findViewById(R.id.signUpName);

        textView1.setText(name);
    }
}
