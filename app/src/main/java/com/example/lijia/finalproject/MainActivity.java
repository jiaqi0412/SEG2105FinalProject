package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {

        Intent i = new Intent(this, adminSignInActivity.class);
        startActivity(i);

    }

    public void onClick2(View view) {

        Intent i = new Intent(this, homeOwnerSignInActivity.class);



        startActivity(i);

    }
    public void onClick3(View view) {

        Intent i = new Intent(this, serviceProviderSignInActivity.class);
        startActivity(i);

    }
//    public void onClick4(View view) {
//
//        Intent i = new Intent(this, welcomePage.class);
//        startActivity(i);
//
//    }
}
