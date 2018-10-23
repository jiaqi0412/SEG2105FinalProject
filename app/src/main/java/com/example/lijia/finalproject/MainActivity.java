package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String type;
    public  int isHomeOwner=0;
    public int isServiceProvider=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        type = "admin";

        Intent i = new Intent(this, signUpActivity.class);
        startActivity(i);

    }

    public void onClick2(View view) {
        type = "home owner";
        isHomeOwner = 1;
        Intent i = new Intent(this, signUpActivity.class);



        startActivity(i);

    }
    public void onClick3(View view) {
        type = "service provider";
        isServiceProvider = 1;
        Intent i = new Intent(this, signUpActivity.class);
        startActivity(i);

    }
    public void onClick4(View view) {

        Intent i = new Intent(this, signInActivity.class);
        startActivity(i);

    }
}
