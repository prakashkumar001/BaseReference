package com.example.lp010.myapplication.activities;

;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lp010.myapplication.R;
import com.example.lp010.myapplication.databinding.AddReviewBinding;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;


public class AddReview extends AppCompatActivity implements View.OnClickListener{
    AddReviewBinding binding;
    EZPhotoPickStorage storage;
    List<Bitmap> alBmp=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.add_review);
        binding= DataBindingUtil.setContentView(this,R.layout.add_review);
        storage=new EZPhotoPickStorage(this);

        binding.iconAddImage.setOnClickListener(this);


    }

    private void selectImage() {

        final CharSequence[] items = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Photo");
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (items[item].equals("Take Photo")) {
                    cameraIntent();

                } else if (items[item].equals("Choose from Gallery")) {
                    galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();


    }

    private void galleryIntent() {

        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.GALLERY;
        config.needToExportThumbnail = true;
        config.isAllowMultipleSelect = true;
        config.storageDir = getString(R.string.app_name);
        config.exportingThumbSize = 200;
        config.exportingSize = 1000;
        EZPhotoPick.startPhotoPickActivity(this, config);
    }

    private void cameraIntent() {

        EZPhotoPickConfig config = new EZPhotoPickConfig();
        config.photoSource = PhotoSource.CAMERA;
        config.storageDir = getString(R.string.app_name);
        config.needToAddToGallery = false;
        config.exportingSize = 1000;
        EZPhotoPick.startPhotoPickActivity(this, config);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == EZPhotoPick.PHOTO_PICK_GALLERY_REQUEST_CODE) {
            try {

                ArrayList<String> pickedPhotoNames =
                        data.getStringArrayListExtra(EZPhotoPick.PICKED_PHOTO_NAMES_KEY);
                showPickedPhotos(getString(R.string.app_name), pickedPhotoNames);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        if (requestCode == EZPhotoPick.PHOTO_PICK_CAMERA_REQUEST_CODE) {
            try {

                Bitmap pickedPhoto = storage.loadLatestStoredPhotoBitmap(0);
                showPickedPhoto(pickedPhoto);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showPickedPhotos(String photoDir, List<String> photoNames) throws IOException {

        for (String photoName : photoNames) {
            Bitmap pickedPhoto = storage.loadStoredPhotoBitmap(photoDir, photoName, 0);
            showPickedPhoto(pickedPhoto);


        }
    }

    private void showPickedPhoto(Bitmap pickedPhoto) {
        fileFromBitmap file=new fileFromBitmap(pickedPhoto,this);

        file.execute();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(pickedPhoto, pickedPhoto.getWidth(),
                pickedPhoto.getHeight(), false);

        alBmp.add(scaledBitmap);

        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View v = layoutInflater.inflate(R.layout.add_image_item, null);
        ImageView iv = v.findViewById(R.id.imgReview);
        iv.setImageBitmap(scaledBitmap);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(24, 0, 24, 0);

        binding.lnrPhotoContainer.addView(v, layoutParams);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v.setTag(binding.lnrPhotoContainer.indexOfChild(v));

                ((LinearLayout) v.getParent()).removeView(v);

                int position = (Integer) v.getTag();

                alBmp.remove(position);
            }
        });
    }

    @Override
    public void onClick(View view) {
        selectImage();
    }




     class fileFromBitmap extends AsyncTask<Void, Integer, String> {

        Context context;
        Bitmap bitmap;
         File direct = new File(Environment.getExternalStorageDirectory() + "/steats");

        public fileFromBitmap(Bitmap bitmap, Context context) {
            this.bitmap = bitmap;
            this.context= context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // before executing doInBackground
            // update your UI
            // exp; make progressbar visible
        }

        @Override
        protected String doInBackground(Void... params) {

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            if (!direct.exists()) {
                direct = new File(Environment.getExternalStorageDirectory() + File.separator + "steats");
                direct.mkdirs();

            }
            File data = new File(direct.getAbsolutePath(), File.separator+"temporary_file.jpg");
            if (data.exists())
                data.delete();
            try {
                FileOutputStream fo = new FileOutputStream(data);
                fo.write(bytes.toByteArray());
                fo.flush();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // back to main thread after finishing doInBackground
            // update your UI or take action after
            // exp; make progressbar gone

            //sendFile(file);

        }

}
}
