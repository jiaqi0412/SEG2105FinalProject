package com.example.lijia.finalproject;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class serviceProviderProfileInfoPage extends AppCompatActivity {
    private TextView tvAddress, tvPhone;

    EditText editTextAddress, editTextPhone,editTextCompanyName, editTextGeneralDescription;

    String address, phone, companyName, generalDescription;

    private FirebaseAuth firebaseAuth;

    private Button updateButton;
    private Button loadButton;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_profile_info_page);

        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        setupUIViews();

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

                firebaseAuth.signOut();
                Toast.makeText(serviceProviderProfileInfoPage.this,
                        "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(serviceProviderProfileInfoPage.this, serviceProviderProfileInfoPage.class));
            }
        });






        //textViewServiceProviderInfo = findViewById(R.id.textViewServiceProviderInfo);

//        firebaseAuth = FirebaseAuth.getInstance();




        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){

                    //sendEmailVerification();
                                sendUserData();
                                firebaseAuth.signOut();
                                Toast.makeText(serviceProviderProfileInfoPage.this,
                                        "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(serviceProviderProfileInfoPage.this, serviceProviderProfileInfoPage.class));




                }
            }
        });



    }

    private void setupUIViews(){
        editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextCompanyName = (EditText)findViewById(R.id.editTextCompanyName);
        editTextGeneralDescription = (EditText)findViewById(R.id.editTextGeneralDescription);
        updateButton = (Button)findViewById(R.id.updateButton);
        //userLogin = (TextView)findViewById(R.id.tvUserLogin);



    }



    public void loadData(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ServiceProviderProfile serviceProviderProfile = dataSnapshot.getValue(ServiceProviderProfile.class);
                tvAddress.setText("Address: "+serviceProviderProfile.getServiceProviderAddress());
                tvPhone.setText("Phone: "+serviceProviderProfile.getServiceProviderPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(serviceProviderProfileInfoPage.this,
                        databaseError.getCode(), Toast.LENGTH_LONG).show();
            }
        });
        ServiceProviderProfile userProfile = new ServiceProviderProfile(address,
                phone, companyName, generalDescription);
        databaseReference.setValue(userProfile);

    }
    private Boolean validate(){
        Boolean result = false;

        address = editTextAddress.getText().toString();
        phone = editTextPhone.getText().toString();
        companyName = editTextCompanyName.getText().toString();
        generalDescription = editTextGeneralDescription.getText().toString();


        if(address.isEmpty() || phone.isEmpty() || companyName.isEmpty() ){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }

    private void sendUserData(){

        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        ServiceProviderProfile userProfile = new ServiceProviderProfile(address,
                phone, companyName, generalDescription);
        myRef.setValue(userProfile);
    }

    public void onClick101(View view) {

        Intent i = new Intent(this, ServiceProviderPage.class);

        startActivity(i);

    }



}
