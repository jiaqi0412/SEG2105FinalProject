package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signUpActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.lijia.finalproject.EXTRA_TEXT";

    public EditText Name;

    private EditText Password;

    private Button SignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText)findViewById(R.id.signUpName);
        Password = (EditText)findViewById(R.id.signUpPassword);
        SignUp = (Button)findViewById(R.id.signUpButton);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String Name, String Password){
        if((Name.equals("admin")) && (Password.equals("admin"))){
            EditText Name1 = (EditText) findViewById(R.id.signUpName);
            String name = Name1.getText().toString();


//            EditText Name = (EditText) findViewById(R.id.signUpName);
            Intent intent = new Intent(signUpActivity.this, welcomePage.class);
            intent.putExtra(EXTRA_TEXT, name);
            startActivity(intent);
        }else{

        }
    }

}
