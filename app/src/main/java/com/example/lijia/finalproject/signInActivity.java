package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signInActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.lijia.finalproject.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "com.example.lijia.finalproject.EXTRA_TEXT1";

    public EditText Name;

    private EditText Password;

    private Button SignUp;
    public  String type;
    public  int isHomeOwner=0;
    public int isServiceProvider=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Name = (EditText)findViewById(R.id.signUpName);
        Password = (EditText)findViewById(R.id.signUpPassword);
        Button SignUp = (Button)findViewById(R.id.signInButton);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    public void validate(String Name, String Password){
        if((Name.equals("admin")) && (Password.equals("admin"))){
            type = "admin";
            EditText Name1 = (EditText) findViewById(R.id.signUpName);
            String name = Name1.getText().toString();

            Intent intent = new Intent(signInActivity.this, welcomePage.class);
            intent.putExtra(EXTRA_TEXT, name);
            intent.putExtra(EXTRA_TEXT1, type);

            startActivity(intent);
        }else if(isHomeOwner == 1){
            type = "home owner";
            EditText Name1 = (EditText) findViewById(R.id.signUpName);
            String name = Name1.getText().toString();

            Intent intent = new Intent(signInActivity.this, welcomePage.class);
            intent.putExtra(EXTRA_TEXT, name);
            intent.putExtra(EXTRA_TEXT1, type);

            startActivity(intent);
        }else if(isServiceProvider == 1){
            type = "service provider";
            EditText Name1 = (EditText) findViewById(R.id.signUpName);
            String name = Name1.getText().toString();

            Intent intent = new Intent(signInActivity.this, welcomePage.class);
            intent.putExtra(EXTRA_TEXT, name);
            intent.putExtra(EXTRA_TEXT1, type);

            startActivity(intent);
        }
    }

}
