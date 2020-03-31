package com.example.firebaseimagesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayImagesActivity extends AppCompatActivity {

    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    ArrayList<ImageUploadInfo>imagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_images);

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(DisplayImagesActivity.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference(MainActivity.Database_Path);

        imagesList = new ArrayList<ImageUploadInfo>();

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    ImageUploadInfo imageUploadInfo = postSnapshot.getValue(ImageUploadInfo.class);

                    imagesList.add(imageUploadInfo);
                }

                ListView listView = findViewById(R.id.list_view);

                ImageListAdapter adapter =
                        new ImageListAdapter(getApplicationContext(), R.layout.adapter_view_layout, imagesList);
                listView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });
    }
}
