package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServiceProviderPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_prodiver_page);
    }

    public void onClick100(View view) {

        Intent i = new Intent(this, serviceProviderProfileInfoPage.class);

        startActivity(i);

    }
}
