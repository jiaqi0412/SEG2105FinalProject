package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeOwnerPage extends AppCompatActivity {

    ListView jobsListView;
    static ArrayList<String> jobsList;
    ArrayAdapter<String> adapter;
    TextView text;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    static List<Service> serviceList;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_owner_page);


        jobsListView = findViewById(R.id.jobsListView);
        jobsList = new ArrayList<>();
        serviceList = new ArrayList<>();
        text = findViewById(R.id.selectedJob);
        databaseReference = FirebaseDatabase.getInstance().getReference("service");

        try {
            Bundle bundle = getIntent().getExtras();
            String name = bundle.getString("serv");
            addToJobs(name);
        }

        catch (Exception e) {
            Toast.makeText(this, "Add services", Toast.LENGTH_SHORT).show();
        }

        jobsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                serviceList.remove(position);
                jobsListView.setAdapter(new ServiceList(HomeOwnerPage.this, serviceList));
            }
        });

    }

    //method to retrieve selected job from database
    public void addToJobs(String job) {

        final String s = job;

        try {
            databaseReference.addValueEventListener(new ValueEventListener() {


                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot serviceSnapshot : dataSnapshot.getChildren()) {

                        if (serviceSnapshot.child("serviceName").getValue().equals(s)) {
                            Service service = serviceSnapshot.getValue(Service.class);
                            serviceList.add(service);
                        }

                        ServiceList adapter = new ServiceList(HomeOwnerPage.this, serviceList);
                        jobsListView.setAdapter(adapter);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        catch (Exception e) {
            Toast.makeText(this, "ERROR addToJobs", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick1000(View view) {
        Intent i = new Intent (this, homeOwnerSearchPage.class);
        startActivity(i);
    }


}
