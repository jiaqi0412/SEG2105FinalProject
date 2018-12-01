package com.example.lijia.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signUpActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.lijia.finalproject.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "com.example.lijia.finalproject.EXTRA_TEXT1";

    public int isHomeOwner=0;
    public int isServiceProvider=0;

    private EditText Password, Name, Email;
    private Button SignUp, suAlready;
    private FirebaseAuth fbAuth;
    private String password;
    public  String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUI();
        Intent intent = getIntent();
        isHomeOwner = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        isServiceProvider = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);
        Button suAlready = (Button) findViewById(R.id.suAlready);
        fbAuth = FirebaseAuth.getInstance();

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() == true){
                    //upload the data to the database
                    String UEmail = Email.getText().toString().trim();
                    password = Password.getText().toString().trim();//trim removes white space
                    password = basicencrypt(password);

                    fbAuth.createUserWithEmailAndPassword(UEmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                                FirebaseUser user = fbAuth.getCurrentUser();

                                ref.child(user.getUid()).child("password").setValue(password);
                                ref.child(user.getUid()).child("availability1").setValue("null");
                                ref.child(user.getUid()).child("availability2").setValue("null");
                                ref.child(user.getUid()).child("availability3").setValue("null");
                                ref.child(user.getUid()).child("availability4").setValue("null");
                                ref.child(user.getUid()).child("serviceProviderAddress").setValue("null");
                                ref.child(user.getUid()).child("serviceProviderCompanyName").setValue("null");
                                ref.child(user.getUid()).child("serviceProviderGeneralDescription").setValue("null");
                                ref.child(user.getUid()).child("serviceProviderPhoneNumber").setValue("null");
                                ref.child(user.getUid()).child("strYesOrNo").setValue("null");

                                Toast.makeText(signUpActivity.this,"SignUp Success!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(signUpActivity.this, Main2Activity.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(signUpActivity.this, "SignUp Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        suAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signUpActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

    }

    private Boolean validate(){
        Boolean result = false;

        String name = Name.getText().toString();
        password = Password.getText().toString();
        String email = Email.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this,"Enter all details", Toast.LENGTH_SHORT).show();
        }
        else if (password.length() <= 5){
            Toast.makeText(this,"Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }
        return result;
    }

    private String basicencrypt(String original) {
        String encrypted = "hehehehe"+original+original+original+"heheheehehe";
        return encrypted;
    }

    private void setUI (){
        Name = (EditText) findViewById(R.id.signUpName);
        Password = (EditText) findViewById(R.id.signUpPassword);
        Email = (EditText) findViewById(R.id.signUpEmail);
        SignUp = (Button) findViewById(R.id.signUpButton);
    }

    public void onClick5(View view) {
       Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);

    }
}

