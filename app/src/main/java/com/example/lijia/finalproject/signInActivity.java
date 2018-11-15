package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signInActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.lijia.finalproject.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "com.example.lijia.finalproject.EXTRA_TEXT1";

    private EditText Password,Name;
    private FirebaseAuth fbAuth;

    private Button SignIn, redirectToSignUp;
    public  String type;
    public String name;
    public  int isHomeOwner=0;
    public int isServiceProvider=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent intent = getIntent();
        isHomeOwner = intent.getIntExtra(Main2Activity.EXTRA_NUMBER1, 0);
        isServiceProvider = intent.getIntExtra(Main2Activity.EXTRA_NUMBER2, 0);

        Name = (EditText)findViewById(R.id.signInName);
        Password = (EditText)findViewById(R.id.signInPassword);
        Button SignIn = (Button)findViewById(R.id.signInButton);
        Button redirectToSignUp = (Button) findViewById(R.id.redirectToSignUp);

        fbAuth = FirebaseAuth.getInstance();

        // We ensure the user is logged off
        FirebaseUser user = fbAuth.getCurrentUser();

        if(user != null){ // Logs off the user automatically
            user = null;
        }

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


        redirectToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signInActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void validate(String Name, String Password){
        if((Name.equals("admin")) && (Password.equals("admin"))){
            type = "admin";
            EditText Name1 = (EditText) findViewById(R.id.signInName);
            name = Name1.getText().toString();

            Intent i = new Intent(signInActivity.this, welcomePage.class);
            i.putExtra(EXTRA_TEXT, name);
            i.putExtra(EXTRA_TEXT1, type);

            startActivity(i);
        }else if(isHomeOwner == 1){
            type = "home owner";
            EditText Name1 = (EditText) findViewById(R.id.signInName);
            name = Name1.getText().toString();

            fbAuth.signInWithEmailAndPassword(Name, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signInActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signInActivity.this, welcomePage.class);
                        intent.putExtra(EXTRA_TEXT, name);
                        intent.putExtra(EXTRA_TEXT1, type);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(signInActivity.this, "Login Fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }else if(isServiceProvider == 1){
            type = "service provider";
            EditText Name1 = (EditText) findViewById(R.id.signInName);
            name = Name1.getText().toString();

            fbAuth.signInWithEmailAndPassword(Name, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signInActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent iSP = new Intent(signInActivity.this, welcomePage.class);
                        iSP.putExtra(EXTRA_TEXT, name);
                        iSP.putExtra(EXTRA_TEXT1, type);
                        startActivity(iSP);
                    }
                    else{
                        Toast.makeText(signInActivity.this, "Login Fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            //Informs us that the isServiceProvider and isHomeOwner is still 0 some reason the values did not change
            Toast.makeText(signInActivity.this, "Unknown Type!", Toast.LENGTH_SHORT).show();
        }

    }

}
