package com.example.firebaseimagesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import com.bumptech.glide.Glide;


public class ImageListAdapter extends ArrayAdapter<ImageUploadInfo> {
    private static final String TAG = "ImageListAdapter";
    private Context mContext;
    private int mResource;
    public ImageListAdapter(Context context, int resource, ArrayList<ImageUploadInfo> list) {
        super(context, resource, list);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the image information
        String imageName = getItem(position).getImageName();
        String imageUrl = getItem(position).getImageURL();

        //Create the employee object with the information
        ImageUploadInfo ImageInfo = new ImageUploadInfo(imageName,imageUrl);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(this.mResource, parent,false);

        TextView imgName = convertView.findViewById(R.id.image_name);
        ImageView imgView= convertView.findViewById(R.id.image_View);
        imgName.setText(imageName);

        //Loading image from Glide library.

        Glide.with(convertView.getContext()).load(imageUrl).into(imgView);

        return convertView;
    }
}

