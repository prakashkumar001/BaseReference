package com.example.lp010.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lp010.myapplication.activities.BaseActivity;
import com.example.lp010.myapplication.activities.SecondActivity;
import com.example.lp010.myapplication.databinding.ActivityMainBinding;
import com.example.lp010.myapplication.interfaces.Result;
import com.example.lp010.myapplication.pojo.MultipleResource;
import com.example.lp010.myapplication.pojo.RestaurentRequest;
import com.example.lp010.myapplication.pojo.RestaurentResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
 //callServer();

 binding.addfragment.setOnClickListener(this);

 callServer();


}

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

    public void callServer()
    {
        RestaurentRequest restaurentRequest=new RestaurentRequest("0","31","13.0314741","80.2715938","2","2","chennai");
        Object object=restaurentRequest;

        callApi("getRestaurent",object,new Result() {
            @Override
            public void onPreExecute() {
                showProgessDialog("","Loading..");
            }

            @Override
            public void onSucess(Object object, int resultCode) {

                hideProgressDialog();


                Log.i("RRRRRRRR","RRRRRRR"+new Gson().toJson(object));
                showMessage(new Gson().toJson(object));
                getNotification(getApplicationContext(),SecondActivity.class);


            }

            @Override
            public void onFailure(String object, int resultCode) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        Bundle b=new Bundle();
        b.putString("name","Prakash");
        b.putString("title","SecondActivity");
        startActivityIntent(MainActivity.this, SecondActivity.class,b);
    }
}
