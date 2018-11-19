package com.example.lijia.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class serviceProviderProfileInfoPage extends AppCompatActivity {
    private TextView tvAddress, tvPhone, tvCompanyName, tvGeneralDescription, tvLicensed
            ,tvAvailability1,tvAvailability2, tvAvailability3
            ,tvAvailability4;

    EditText editTextAddress, editTextPhone,editTextCompanyName, editTextGeneralDescription
            ,editText1, editText2, editText3, editText4;

    String address, phone, companyName, generalDescription, strYesOrNo
            ,A1,  A2, A3
            , A4;

    private FirebaseAuth firebaseAuth;

    private Button updateButton;
    private FirebaseDatabase firebaseDatabase;
    RadioGroup licensedRadioGroup;
    RadioButton yesOrNoOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_profile_info_page);

        Button updateButton = (Button) findViewById(R.id.updateButton);
        tvAddress = findViewById(R.id.tvAddress);
        tvPhone = findViewById(R.id.tvPhone);
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvGeneralDescription = findViewById(R.id.tvGeneralDescription);
        tvLicensed = findViewById(R.id.tvLicensed);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        tvAvailability1 = findViewById(R.id.tvAvailability1);
        tvAvailability2 = findViewById(R.id.tvAvailability2);
        tvAvailability3 = findViewById(R.id.tvAvailability3);
        tvAvailability4 = findViewById(R.id.tvAvailability4);

        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

        setupUIViews();
        licensedRadioGroup = findViewById(R.id.radioGroup);

        licensedRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                yesOrNoOption = licensedRadioGroup.findViewById(checkedId);

                switch (checkedId){
                    case R.id.radioButtonYes:
                        strYesOrNo = yesOrNoOption.getText().toString();
                        break;
                    case R.id.radioButtonNo:
                        strYesOrNo = yesOrNoOption.getText().toString();
                        break;

                    default:
                }
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ServiceProviderProfile spp = dataSnapshot.getValue(ServiceProviderProfile.class);
                tvAddress.setText("Address: "+spp.getServiceProviderAddress());
                tvPhone.setText("Phone: "+spp.getServiceProviderPhone());
                tvCompanyName.setText("Company Name: "+spp.getServiceProviderCompanyName());
                tvGeneralDescription.setText("General Description: "+spp.getServiceProviderGeneralDescription());
                tvLicensed.setText("Licensed: "+spp.getStrYesOrNo());
                tvAvailability1.setText("Availability1: "+spp.getAvailability1());
                tvAvailability2.setText("Availability2: "+spp.getAvailability2());
                tvAvailability3.setText("Availability3: "+spp.getAvailability3());
                tvAvailability4.setText("Availability4: "+spp.getAvailability4());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(serviceProviderProfileInfoPage.this,
                        databaseError.getCode(), Toast.LENGTH_LONG).show();
            }
        });



        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //sendEmailVerification();
                    sendUserData();
                    //firebaseAuth.signOut();
                    Toast.makeText(serviceProviderProfileInfoPage.this, "Upload complete!", Toast.LENGTH_SHORT).show();
                    //finish();

                   // startActivity(new Intent(serviceProviderProfileInfoPage.this, ServiceProviderProfile.class));

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

    }

    private Boolean validate(){
        Boolean result = false;

        address = editTextAddress.getText().toString();
        phone = editTextPhone.getText().toString();
        companyName = editTextCompanyName.getText().toString();
        generalDescription = editTextGeneralDescription.getText().toString();
        A1 = editText1.getText().toString();
        A2 = editText2.getText().toString();
        A3 = editText3.getText().toString();
        A4 = editText4.getText().toString();
        //strYesOrNo = yesOrNoOption.getText().toString();


        if(address.isEmpty() || phone.isEmpty() || companyName.isEmpty()){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }

    private void sendUserData(){
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        ServiceProviderProfile userProfile = new ServiceProviderProfile(address, phone, companyName, generalDescription, strYesOrNo, A1,  A2, A3
                , A4);
        myRef.setValue(userProfile);
    }

    public void onClick101(View view) {

        Intent i = new Intent(this, ServiceProviderPage.class);

        startActivity(i);

    }


}
