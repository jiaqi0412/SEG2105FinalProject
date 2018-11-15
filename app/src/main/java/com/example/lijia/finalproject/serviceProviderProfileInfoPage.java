package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class serviceProviderProfileInfoPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_profile_info_page);
    }

    public void onClick101(View view) {

        Intent i = new Intent(this, ServiceProviderPage.class);

        startActivity(i);

    }
}
