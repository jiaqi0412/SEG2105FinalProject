package com.example.lijia.finalproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class service_provider_add_service_2 extends AppCompatActivity {

    EditText editTextHourlyRate;
    ListView listViewService;
    List<Service> serviceList;
    List<Service> currentServices;
    DatabaseReference databaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_add_service_2);

        databaseService = FirebaseDatabase.getInstance().getReference("service");
        listViewService = (ListView) findViewById(R.id.listViewService);
        serviceList = new ArrayList<>();
        currentServices = new ArrayList<>();



        listViewService.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){

                FirebaseAuth fbAuth = FirebaseAuth.getInstance();
                final FirebaseUser user = fbAuth.getCurrentUser();
                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("servicesOffered");
                final Service service = serviceList.get(i);

                ref.orderByChild("serviceId").equalTo(service.getServiceId()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (!dataSnapshot.exists()) {
                            Toast.makeText(service_provider_add_service_2.this,"Service successfully added!", Toast.LENGTH_SHORT).show();
                            final String id = ref.push().getKey();
                            FirebaseDatabase.getInstance().getReference().child(user.getUid()).child("keys").child(service.getServiceId()).setValue(id);
                            ref.child(id).setValue(service);
                        } else if (dataSnapshot.exists()){
                            Toast.makeText(service_provider_add_service_2.this, "Done.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                return true;
            }

        });
    }

    @Override
    protected void onStart(){

        super.onStart();

        databaseService.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){

                serviceList.clear();
                for(DataSnapshot serviceSnapshot : dataSnapshot.getChildren()){
                    Service service = serviceSnapshot.getValue(Service.class);

                    serviceList.add(service);
                }

                ServiceList adapter = new ServiceList(service_provider_add_service_2.this, serviceList);
                listViewService.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });

    }


}
