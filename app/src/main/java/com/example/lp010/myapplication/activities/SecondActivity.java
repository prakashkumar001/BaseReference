package com.example.lp010.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lp010.myapplication.R;
import com.example.lp010.myapplication.fragment.FirstFragment;

public class SecondActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        addFragment(R.id.frame,new FirstFragment(),"FirstFragment");

    }
}
