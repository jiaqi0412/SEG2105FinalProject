package com.example.lijia.finalproject;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeOwnerRate extends AppCompatActivity {

    DatabaseReference databaseReference;
    EditText comment;
    RadioGroup radioButtonGroup;
    Button submitButton;
    RadioButton radioButton;
    String rating;
    //String commentString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_owner_rate);
        Bundle bundle = getIntent().getExtras();

        final String name = bundle.getString("serv");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("service");
        comment = findViewById(R.id.commentEditText);
        radioButtonGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioButtonGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                rating = radioButton.getText().toString();
                //commentString = comment.getText().toString();

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            if (data.child("serviceName").getValue().toString().equals(name)) {
                                DatabaseReference ratingId = data.getRef().child("ratings").push();
                                DatabaseReference commentId = data.getRef().child("comments").push();
                                ratingId.setValue(rating);
                                commentId.setValue(comment.getText().toString());
                                Toast.makeText(HomeOwnerRate.this, "Your feedback has been submitted, thank you.", Toast.LENGTH_SHORT).show();

                                final DatabaseReference serviceRatingRef = data.getRef().child("averageRating").push();
                                final DatabaseReference averageToDelete = data.getRef().child("averageRating");

                                data.getRef().child("ratings").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        ArrayList<Integer> allRatings = new ArrayList<>();
                                        for (DataSnapshot ratingData : dataSnapshot.getChildren()) {
                                            allRatings.add(Integer.parseInt(ratingData.getValue().toString()));
                                        }

                                        int total = 0;
                                        for (int i = 0; i < allRatings.size(); i++) {
                                            total += allRatings.get(i);
                                        }

                                        double average = (double) total/allRatings.size();
                                        averageToDelete.removeValue();
                                        serviceRatingRef.setValue(average);
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                //DatabaseReference ratingId = databaseReference.child(name).child("rating").push();
                //DatabaseReference commentId = databaseReference.child(name).child("service").push();
                //ratingId.setValue(rating);
                //commentId.setValue(comment.getText().toString());
                //databaseService.child(name).child("comments")
            }
        });



    }

    public void onClickSubmit(View view) {

    }
}
