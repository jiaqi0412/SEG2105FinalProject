package com.example.lijia.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class welcomePage extends AppCompatActivity {

    public String typeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        Intent intent = getIntent();
        String name = intent.getStringExtra(signInActivity.EXTRA_TEXT);
        String type = intent.getStringExtra(signInActivity.EXTRA_TEXT1);


        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button goToProfile = (Button)findViewById(R.id.goToProfile);


        textView1.setText(name);
        textView2.setText(type);
        typeUser = textView2.getText().toString();

        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(typeUser);
            }
        });
    }
//    public void onClick12(View view) {
//        Intent i = new Intent(this, adminProfile.class);
//
//        startActivity(i);
//
//    }
public void validate(String typeUser){
    if((typeUser.equals("admin")) ){

        Intent i = new Intent(welcomePage.this, adminProfile.class);


        startActivity(i);
    }else if((typeUser.equals("service provider"))){


        Intent i1 = new Intent(welcomePage.this, ServiceProviderPage.class);


        startActivity(i1);

    }else if((typeUser.equals("home owner"))){
        Intent i2 = new Intent(welcomePage.this, HomeOwnerPage.class);


        startActivity(i2);
    }
    else{
        //Informs us that the isServiceProvider and isHomeOwner is still 0 some reason the values did not change
        Toast.makeText(welcomePage.this, "Unknown Type!", Toast.LENGTH_SHORT).show();
    }

}

}








