package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminProfile extends AppCompatActivity {

    EditText serviceName;
    EditText serviceHourlyRate;
    Button adminAddService;
    ServiceList listViewServices;

    DatabaseReference databaseService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        databaseService = FirebaseDatabase.getInstance().getReference("service");

        serviceName = (EditText) findViewById(R.id.serviceName);
        serviceHourlyRate = (EditText) findViewById(R.id.serviceHourlyRate);
        adminAddService = (Button) findViewById(R.id.adminAddService);

        adminAddService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                addService();
            }
        });


    }





    private void addService(){

        String name = serviceName.getText().toString().trim();
        String hourlyRate = serviceHourlyRate.getText().toString().trim();

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(hourlyRate)){

            String id = databaseService.push().getKey();

            Service service = new Service(id, name, hourlyRate);

            databaseService.child(id).setValue(service);

            Toast.makeText(this, "Service added", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "You should enter a name/rate",Toast.LENGTH_LONG).show();
        }
    }

    public void onClick10(View view) {
        Intent i = new Intent(this, adminEditOrRemoveService.class);

        startActivity(i);

    }

    public void onClick11(View view) {
        Intent i = new Intent(this, adminEditOrRemoveService.class);

        startActivity(i);

    }
}
