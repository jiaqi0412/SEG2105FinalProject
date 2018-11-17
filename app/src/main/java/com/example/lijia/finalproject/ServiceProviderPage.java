package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    DatabaseReference databaseService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_prodiver_page);

        databaseService = FirebaseDatabase.getInstance().getReference("serviceProviderInfo");

        serviceProviderAddress = (EditText) findViewById(R.id.editText);
        serviceProviderPhone = (EditText) findViewById(R.id.editText2);
        serviceProviderCompanyName = (EditText) findViewById(R.id.editText3);
        serviceProviderGeneralDescription = (EditText) findViewById(R.id.editText4);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                addServiceProvider();
            }
        });
    }

    private void addServiceProvider(){

        String address = serviceProviderAddress.getText().toString().trim();
        String phone = serviceProviderPhone.getText().toString().trim();
        String companyName = serviceProviderCompanyName.getText().toString().trim();
        String generalDescription = serviceProviderGeneralDescription.getText().toString().trim();

        if(!TextUtils.isEmpty(address) && !TextUtils.isEmpty(phone)&& !TextUtils.isEmpty(companyName)){

            String id = databaseService.push().getKey();

            ServiceProviderProfile serviceProvider = new ServiceProviderProfile(id, address,
                    phone, companyName, generalDescription);

            databaseService.child(id).setValue(serviceProvider);

            Toast.makeText(this, "Service provider added", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "You should enter a address/phone/company name",Toast.LENGTH_LONG).show();
        }
    }

    public void onClick100(View view) {

        Intent i = new Intent(this, serviceProviderProfileInfoPage.class);

        startActivity(i);

    }
}
