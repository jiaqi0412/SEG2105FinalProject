package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import javax.xml.validation.Validator;

public class serviceProviderProfileInfoPage extends AppCompatActivity {

    EditText address;
    EditText phone;
    EditText companyName;
    EditText generalDescription;
    ListView ServiceProviderInfoList;
    List<ServiceProviderProfile> serviceProviderInfoList;
    DatabaseReference databaseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_profile_info_page);
        databaseService = FirebaseDatabase.getInstance().getReference("serviceProviderInfo");
        ServiceProviderInfoList = (ListView) findViewById(R.id.ServiceProviderInfoList);
        serviceProviderInfoList = new ArrayList<>();

        ServiceProviderInfoList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){
                ServiceProviderProfile serviceProfile = serviceProviderInfoList.get(i);

                showUpdateDialog(serviceProfile.getServiceProviderAddress(),serviceProfile.getServiceProviderPhone(),
                        serviceProfile.getServiceProviderGeneralDescription(), serviceProfile.getServiceProviderCompanyName());
                return false;
            }

        });
    }

    public void onClick101(View view) {

        Intent i = new Intent(this, ServiceProviderPage.class);

        startActivity(i);

    }

    private void showUpdateDialog(final String serviceProviderAddress, final String serviceProviderPhone,
                                  final String serviceProviderGeneralDescription, final String serviceProviderCompanyName){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.update_dialog_service_provider, null);

        dialogBuilder.setView(dialogView);

        final EditText textViewServiceHourlyRate = (EditText) dialogView.findViewById(R.id.editTextHourlyRate);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdate);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle("Updating Service " + serviceId);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                String HourlyRate = textViewServiceHourlyRate.getText().toString().trim();
                if(TextUtils.isEmpty(HourlyRate)){
                    textViewServiceHourlyRate.setError("Service Hourly Rate required");
                    return;
                }
                updateService(serviceId,serviceName, HourlyRate);

                alertDialog.dismiss();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                deleteService(serviceId);
            }
        });


    }

    private void deleteService(String serviceId){

        DatabaseReference Service = FirebaseDatabase.getInstance().getReference("service").child(serviceId);

        Service.removeValue();

        Toast.makeText(this, "Service is deleted", Toast.LENGTH_LONG).show();
    }

    private boolean updateService(String id, String name, String serviceHourlyRate){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("service").child(id);

        Service service = new Service(id, name, serviceHourlyRate);

        databaseReference.setValue(service);

        Toast.makeText(this, "Service Updated Successfully", Toast.LENGTH_LONG).show();

        return true;
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

                ServiceList adapter = new ServiceList(adminEditOrRemoveService.this, serviceList);
                listViewService.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });
    }
}
