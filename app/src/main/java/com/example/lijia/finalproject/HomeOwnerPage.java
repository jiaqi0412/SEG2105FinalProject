package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeOwnerPage extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_owner_page);
    }

    public void onClick1000(View view) {

        Intent i = new Intent (this, homeOwnerSearchPage.class);
        startActivity(i);

    }
}
