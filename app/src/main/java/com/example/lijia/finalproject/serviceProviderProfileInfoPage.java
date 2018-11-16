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

        final EditText textViewServiceProviderAddress = (EditText) dialogView.findViewById(R.id.address2);
        final EditText textViewServiceProviderPhone = (EditText) dialogView.findViewById(R.id.phone2);
        final EditText textViewServiceProviderGeneralDescription = (EditText) dialogView.findViewById(R.id.generalDescription2);
        final EditText textViewServiceProviderCompanyName = (EditText) dialogView.findViewById(R.id.companyName2);
        final Button update = (Button) dialogView.findViewById(R.id.update);


        dialogBuilder.setTitle("Updating service Provider Company Name " + serviceProviderCompanyName);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                String ServiceProviderAddress = textViewServiceProviderAddress.getText().toString().trim();
                String ServiceProviderPhone = textViewServiceProviderPhone.getText().toString().trim();
                String ServiceProviderGeneralDescription = textViewServiceProviderGeneralDescription.getText().toString().trim();
                String ServiceProviderCompanyName = textViewServiceProviderCompanyName.getText().toString().trim();
                if(TextUtils.isEmpty(ServiceProviderAddress)){
                    textViewServiceProviderAddress.setError("Service Provider Address required");
                    return;
                }
                else if(TextUtils.isEmpty(ServiceProviderPhone)){
                    textViewServiceProviderPhone.setError("Service Provider Phone required");
                    return;
                }

                else if(TextUtils.isEmpty(ServiceProviderCompanyName)){
                    textViewServiceProviderCompanyName.setError("Service Provider CompanyName required");
                    return;
                }
                updateService(ServiceProviderAddress,ServiceProviderPhone, ServiceProviderGeneralDescription, ServiceProviderCompanyName);

                alertDialog.dismiss();
            }
        });




    }


    private boolean updateService(String ServiceProviderAddress, String ServiceProviderPhone,
                                  String ServiceProviderCompanyName, String ServiceProviderGeneralDescription){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("serviceProviderInfo").child(ServiceProviderCompanyName);

        ServiceProviderProfile serviceProviderProfile = new ServiceProviderProfile(ServiceProviderAddress,
                ServiceProviderPhone, ServiceProviderCompanyName, ServiceProviderGeneralDescription);

        databaseReference.setValue(serviceProviderProfile);

        Toast.makeText(this, "Service Provider ProfileUpdated Successfully", Toast.LENGTH_LONG).show();

        return true;
    }
    @Override
    protected void onStart(){

        super.onStart();

        databaseService.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){

                serviceProviderInfoList.clear();
                for(DataSnapshot serviceSnapshot : dataSnapshot.getChildren()){
                    ServiceProviderProfile serviceProviderProfile = serviceSnapshot.getValue(ServiceProviderProfile.class);

                    serviceProviderInfoList.add(serviceProviderProfile);
                }

                ServiceProviderInfoList adapter = new ServiceProviderInfoList(serviceProviderProfileInfoPage.this, serviceProviderInfoList);
                ServiceProviderInfoList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }

        });
    }
}
