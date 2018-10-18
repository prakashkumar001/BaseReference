package com.example.lp010.myapplication.upload;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.lp010.myapplication.APIClient;
import com.example.lp010.myapplication.MainActivity;
import com.example.lp010.myapplication.R;
import com.example.lp010.myapplication.interfaces.APIInterface;
import com.example.lp010.myapplication.interfaces.BaseView;
import com.example.lp010.myapplication.interfaces.Notify;
import com.example.lp010.myapplication.interfaces.Result;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadService extends IntentService  {
    public UploadService() {
        super("");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {


            if (intent.hasExtra("url") && intent.hasExtra("requestBody")) {

                String url = intent.getStringExtra("url");
                List<FileUpload> imageUploads = (List<FileUpload>) intent.getSerializableExtra("requestBody");

                if (imageUploads != null)
                    postMultipart(url, imageUploads);
            }
        }
    }

    public void postMultipart(String url, List<FileUpload> images) {

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);


        // Map is used to multipart the file using okhttp3.RequestBody
        // Multiple Images
        for (int i = 0; i < images.size(); i++) {
            File file = new File(images.get(i).getFilePath());
            builder.addFormDataPart("file[]", file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }


        MultipartBody requestBody = builder.build();


        uploadMultipleImage(requestBody,new Result() {
             @Override
             public void onPreExecute() {

             }

             @Override
             public void onSucess(Object object, int resultCode) {


                 sendMessage(object.toString(),"");
             }

             @Override
             public void onFailure(String message, int resultCode) {

             }
         });


    }

    public void uploadMultipleImage(RequestBody requestBody,final Result result)
    {
        result.onPreExecute();
        Call call=null;

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

         call=apiInterface.createUser(requestBody);


        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {

                Log.i("TEST","TEST");

                result.onSucess(response.body().toString(),1);

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.i("TEST","TEST");

                result.onFailure(t.getMessage(),0);
                call.cancel();
            }
        });


    }



    private void sendMessage(String response, String url) {

        Log.d("sender", "Broadcasting message" + response);
        Intent intent = new Intent("Url");

        // You can also include some extra data.
        intent.putExtra("response", response);
        intent.putExtra("url", url);
        LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
    }
}