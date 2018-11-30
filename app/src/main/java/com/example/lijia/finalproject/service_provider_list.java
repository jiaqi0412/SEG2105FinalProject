package com.example.lijia.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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
    ListView allServices;
    List<Service> serviceListTemp;
    List<Service> serviceList;
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
        Button addServices = (Button) findViewById(R.id.addServices);


        databaseService.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                serviceList.clear();
/*
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Service service = data.getValue(Service.class);
                    serviceListTemp.add(service);
                }

                for (Service service : serviceListTemp) {
                    String id = service.getServiceId();
                    String rate = service.getServiceHourlyRate();
                    String name = service.getServiceName();
                    Service serv = new Service(id, name, rate);

                    if (!serviceList.contains(serv)) {
                        serviceList.add(service);
                    }
                }

                ServiceList adapter = new ServiceList(service_provider_list.this, serviceList);
                listViewService.setAdapter(adapter);
*/

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

                ServiceList adapter = new ServiceList(service_provider_list.this, serviceList);
                listViewService.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listViewService.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Service serv = serviceList.get(position);
                final String servId = serv.getServiceId();
                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("servicesOffered").child(servId);

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            //serviceList.remove(position);
                            //ServiceList adapter = new ServiceList(service_provider_list.this, serviceList);
                            //listViewService.setAdapter(adapter);
                            //ref.removeValue();
                        } else if (dataSnapshot.exists()){
                            Toast.makeText(service_provider_list.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                /*
                serviceList.remove(position);
                ServiceList adapter = new ServiceList(service_provider_list.this, serviceList);
                listViewService.setAdapter(adapter);
*/
                return true;
            }
        });

    }


    public void onClick100(View view) {

    Intent intent = new Intent(this, service_provider_add_service_2.class);
    startActivity(intent);

    }


/*
    @Override
    protected void onStart {
        super.onStart();

        databaseService.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){

                serviceList.clear();
                for(DataSnapshot serviceSnapshot : dataSnapshot.getChildren()){
                    Service service = serviceSnapshot.getValue(Service.class);

                    serviceList.add(service);
                }

                ServiceList adapter = new ServiceList(service_provider_list.this, serviceList);
                listViewService.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });
    }
*/
}
