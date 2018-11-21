package com.example.lijia.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

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
    DatabaseReference databaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_add_service_2);
        databaseService = FirebaseDatabase.getInstance().getReference("service");
        listViewService = (ListView) findViewById(R.id.listViewService);
        serviceList = new ArrayList<>();


        listViewService.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
                Service service = serviceList.get(i);

                return false;
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
