package com.example.lijia.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class service_provider_list extends AppCompatActivity {

    //EditText editTextHourlyRate;
    ListView listViewService;
    List<Service> serviceListTemp;
    List<Service> serviceList;
    List<String> keys;

    ArrayAdapter<Service> adapter;

    DatabaseReference databaseService;
    FirebaseUser user;
    FirebaseAuth fbAuth;
    Button addServices;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_list);
        fbAuth = FirebaseAuth.getInstance();
        user = fbAuth.getCurrentUser();
        databaseService = FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("servicesOffered");
        listViewService = (ListView) findViewById(R.id.serviceListView);
        serviceListTemp = new ArrayList<>();
        serviceList = new ArrayList<>();
        adapter = new ArrayAdapter<Service>(this, R.layout.activity_service_provider_list, serviceList);


        //to remove services from visible service list and the database
        listViewService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final DatabaseReference localRef = FirebaseDatabase.getInstance().getReference(user.getUid());
                final Service service = serviceList.get(position);
                final String serviceId = service.getServiceId();

                //to access value of a "key" directory child
                localRef.child("keys").child(serviceId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue().toString();
                        localRef.child("servicesOffered").child(value).removeValue();
                        localRef.child("keys").child(serviceId).removeValue();
                        Toast.makeText(service_provider_list.this,"Service removed.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                serviceList.remove(position);
                listViewService.setAdapter(new ServiceList(service_provider_list.this, serviceList));
            }
        });

        //to display the service provider's list of services, obtained from database, to the user
        databaseService.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                serviceList.clear();

                for (DataSnapshot data : dataSnapshot.getChildren()){
                    Service service = data.getValue(Service.class);
                    serviceList.add(service);
                }

                for (Service s : serviceList) {
                    int count = 0;

                    for (Service j : serviceList) {
                        if (s.equals(j)) {
                            count++;
                        }

                        if (count > 1) {
                            serviceList.remove(j);
                        }
                    }
                }

                adapter = new ServiceList(service_provider_list.this, serviceList);
                listViewService.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void onClick100(View view) {

    Intent intent = new Intent(this, service_provider_add_service_2.class);
    startActivity(intent);

    }


}
