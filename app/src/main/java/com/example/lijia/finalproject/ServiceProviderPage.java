package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ServiceProviderPage extends AppCompatActivity {

    EditText serviceProviderAddress;
    EditText serviceProviderPhone;
    EditText serviceProviderCompanyName;
    EditText serviceProviderGeneralDescription;
    Button addButton;
    Button profileInfoButton;
    DatabaseReference databaseService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_prodiver_page);

        databaseService = FirebaseDatabase.getInstance().getReference("serviceProviderInfo");

        profileInfoButton= (Button) findViewById(R.id.profileInfoButton);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.profileMenu:
                startActivity(new Intent(ServiceProviderPage.this, serviceProviderProfileInfoPage.class));
        }
        return super.onOptionsItemSelected(item);
    }



    public void onClick1000(View view) {

        Intent i = new Intent(this, serviceProviderProfileInfoPage.class);

        startActivity(i);

    }
}
