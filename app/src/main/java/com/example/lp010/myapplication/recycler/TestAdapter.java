package com.example.lp010.myapplication.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.lp010.myapplication.model.User;
import com.example.lp010.myapplication.recycler.viewHolder.BaseViewHolder;

import java.util.List;

public abstract class TestAdapter extends BaseRecyclerViewAdapter<User,BaseViewHolder>  {

    public TestAdapter(List<User> items, Context context) {
        super(items, context);
    }


}
