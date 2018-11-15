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


public class signUpActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.lijia.finalproject.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "com.example.lijia.finalproject.EXTRA_TEXT1";

    public int isHomeOwner=0;
    public int isServiceProvider=0;

    private EditText Password, Name, Email;
    private Button SignUp, suAlready;
    private FirebaseAuth fbAuth;

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

//        Intent intent = getIntent();
//        isHomeOwner = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
//        isServiceProvider = intent.getIntExtra(MainActivity.EXTRA_NUMBER2, 0);

//        TextView textView3 = (TextView) findViewById(R.id.textView3);
//        //TextView textView2 = (TextView) findViewById(R.id.textView2);
//
//        textView3.setText("" + isHomeOwner);


//        Name = (EditText)findViewById(R.id.signUpName);
//        Password = (EditText)findViewById(R.id.signUpPassword);
//        Button SignUp = (Button)findViewById(R.id.signUpButton);
//
//        SignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                validate(Name.getText().toString(), Password.getText().toString());
//            }
//        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() == true){
                    //upload the data to the database
                    String UEmail = Email.getText().toString().trim();
                    String UPass = Password.getText().toString().trim();//trim removes white space

                    fbAuth.createUserWithEmailAndPassword(UEmail,UPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
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
        String password = Password.getText().toString();
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
//    public void validate(String Name, String Password){
//        if((Name.equals("admin")) && (Password.equals("admin"))){
//            type = "admin";
//            EditText Name1 = (EditText) findViewById(R.id.signUpName);
//            String name = Name1.getText().toString();
//
//            Intent intent = new Intent(signUpActivity.this, welcomePage.class);
//            intent.putExtra(EXTRA_TEXT, name);
//            intent.putExtra(EXTRA_TEXT1, type);
//
//            startActivity(intent);
//        }else if(isHomeOwner == 1){
//            type = "home owner";
//            EditText Name1 = (EditText) findViewById(R.id.signUpName);
//            String name = Name1.getText().toString();
//
//            Intent intent = new Intent(signUpActivity.this, welcomePage.class);
//            intent.putExtra(EXTRA_TEXT, name);
//            intent.putExtra(EXTRA_TEXT1, type);
//
//            startActivity(intent);
//        }else if(isServiceProvider == 1){
//            type = "service provider";
//            EditText Name1 = (EditText) findViewById(R.id.signUpName);
//            String name = Name1.getText().toString();
//
//            Intent intent = new Intent(signUpActivity.this, welcomePage.class);
//            intent.putExtra(EXTRA_TEXT, name);
//            intent.putExtra(EXTRA_TEXT1, type);
//
//            startActivity(intent);
//        }
//    }
}

