package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    public static final String EXTRA_NUMBER1 = "com.example.lijia.finalproject.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.lijia.finalproject.EXTRA_NUMBER2";
    String type;
    public  int isHomeOwner=0;
    public int isServiceProvider=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void onClick1(View view) {
        type = "admin";

        Intent i = new Intent(this, signInActivity.class);

        startActivity(i);

    }

    public void onClick2(View view) {
        type = "home owner";
        isHomeOwner = 1;
        Intent i = new Intent(this, signInActivity.class);
        i.putExtra(EXTRA_NUMBER1, isHomeOwner);

        startActivity(i);

    }
    public void onClick3(View view) {
        type = "service provider";
        isServiceProvider = 1;
        Intent i = new Intent(this, signInActivity.class);
        i.putExtra(EXTRA_NUMBER2, isServiceProvider);
        startActivity(i);

    }

}
