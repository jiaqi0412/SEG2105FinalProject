package com.example.lijia.finalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class service_provider_list extends AppCompatActivity {

    //EditText editTextHourlyRate;
    ListView listViewService;
    ListView allServices;
    List<Service> serviceList;
    DatabaseReference databaseService;
    Button addServices;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_list);
        databaseService = FirebaseDatabase.getInstance().getReference("service");
        listViewService = (ListView) findViewById(R.id.serviceListView);
        serviceList = new ArrayList<>();
        Button addServices = (Button) findViewById(R.id.addServices);


    }



    public void onClick100(View view) {

    Intent intent = new Intent(this, service_provider_add_service_2.class);
    startActivity(intent);

    }

}
