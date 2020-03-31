package com.example.firebaseimagesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

public class UploadActivity extends AppCompatActivity {

    Button ChooseButton, UploadButton;
    EditText ImageName ;
    ImageView SelectImage;
    Uri FilePathUri;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    int Image_Request_Code = 7;

    ProgressDialog progressDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
    }
}
