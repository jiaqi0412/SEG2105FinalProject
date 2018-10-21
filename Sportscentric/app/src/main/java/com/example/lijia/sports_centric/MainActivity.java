package com.example.lijia.sports_centric;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void onClick(View view){
//
//
//    }
//    ImageView Button = (ImageView)findViewById(R.id.button);
//
//    Button.setOnClickListener(new OnClickListener() {
//        public void onClick(View v) {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.addCategory(Intent.CATEGORY_BROWSABLE);
//            intent.setData(Uri.parse("http://www.google.com"));
//            startActivity(intent);
//        }
//    });



    public void onClick1(View view) {
        //creating a new intent objcet, setting the current context to this,
        //and specifying the target activity "Berries.class"
        Intent i = new Intent(this, changeLogo.class);

        //retrieving the EditText object that contains the user message, we find
        //it using the findViewById function that allows us to retrieve a UI component
        //by it's ID
        //final  image imageView = findViewById(R.id.Logo);

        //getting the actual message contained in the EditText as string
        //String userMessage = imageView.getText().toString();

        //adding the user message as an additional information with the intent as
        //key-value pair. you can add as much key-value pairs as you want and send them
        //with the intent. You retrieve a value by it's corresponding key
        //i.putExtra("teamName", userMessage);

        startActivity(i);

    }

    public void onClick2(View view) {
        //creating a new intent objcet, setting the current context to this,
        //and specifying the target activity "Berries.class"
        Intent i = new Intent(this, setAddress.class);

        //retrieving the EditText object that contains the user message, we find
        //it using the findViewById function that allows us to retrieve a UI component
        //by it's ID
        final EditText teamAddress = (EditText) findViewById(R.id.teamAddress);

        //getting the actual message contained in the EditText as string
        String userMessage = teamAddress.getText().toString();

        //adding the user message as an additional information with the intent as
        //key-value pair. you can add as much key-value pairs as you want and send them
        //with the intent. You retrieve a value by it's corresponding key
        i.putExtra("teamAddress", userMessage);

        startActivity(i);
    }




    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddress);
// Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
// Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;
//Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logo);
//Figuring out the correct image
        String drawableName = "ic_logo_00";
        switch (data.getIntExtra("imageID",R.id.teamid00)) {
            case R.id.teamid00:
                drawableName = "ic_logo_00";
                break;
            case R.id.teamid01:
                drawableName = "ic_logo_01";
                break;
            case R.id.teamid02:
                drawableName = "ic_logo_02";
                break;
            case R.id.teamid03:
                drawableName = "ic_logo_03";
                break;
            case R.id.teamid04:
                drawableName = "ic_logo_04";
                break;
            case R.id.teamid05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);
    }


    public void OnSetAvatarButton(View view) {
//Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), changeLogo.class);
        startActivityForResult (intent,0);
    }
}
