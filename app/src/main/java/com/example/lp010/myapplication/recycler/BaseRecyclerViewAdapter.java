package com.example.lp010.myapplication.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T, Z extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<Z> {
    protected final Context mContext;
    protected List<T> mItems;

    public BaseRecyclerViewAdapter(List<T> items, Context context) {
        if (items == null) {
            items = new ArrayList<T>();
        }
        mItems = items;
        mContext = context;
    }

    public void add(T item, int position) {
        if (item == null) {
            return;
        }
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void add(List<T> items, int position) {
        if (items == null || items.isEmpty()) {
            return;
        }
        mItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public void add(T item) {
        int position = mItems.size();
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void add(List<T> items) {
        if (items.isEmpty()) {
            return;
        }
        int position = mItems.isEmpty() ? 0 : mItems.size();
        mItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public T getItem(int position) {
        return mItems.get(position);
    }

    public List<T> getItems() {
        return mItems;
    }

    public int getItemCount() {
        return mItems.size();
    }

    /**
     * Requires equals() and hashcode() to be implemented in T class.
     */
    public void remove(T item) {
        int position = mItems.indexOf(item);
        if (position == -1) {
            return;
        }
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position, int itemCount) {
        for (int i = position; i < itemCount; i++) {
            mItems.remove(i);
        }
        notifyItemRangeRemoved(position, itemCount);
    }

    public void replaceList(List<T> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }
}