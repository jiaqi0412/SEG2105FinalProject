package com.example.lijia.sports_centric;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class changeLogo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_logo);
    }


    public void SetTeamIcon0(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
    public void SetTeamIcon1(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }

    public void SetTeamIcon2(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
    public void SetTeamIcon3(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
    public void SetTeamIcon4(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
    public void SetTeamIcon5(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }


//    File file = new File(Environment.getExternalStorageDirectory() + "/DCIM/", "image" + new Date().getTime() + ".png");
//    Uri imgUri = Uri.fromFile(file);
//    String imgPath = file.getAbsolutePath();
//    final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//    intent.putExtra(MediaStore.EXTRA_OUTPUT, setImageUri());
//    startActivityForResult(intent, CAPTURE_IMAGE);
//
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode != Activity.RESULT_CANCELED) {
//            if (requestCode == CAPTURE_IMAGE) {
//                ImageView imageView = (ImageView) findViewById(R.id.imgView);
//                imageView.setImageBitmap(BitmapFactory.decodeFile(imgPath));
//            }}}
//
//    Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//    startActivityForResult(i, RESULT_LOAD_IMAGE);
//
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
//            cursor.moveToFirst();
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            ImageView imageView = (ImageView) findViewById(R.id.imgView);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//        }}
}
