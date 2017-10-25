package com.example.sidkathuria14.mapsclone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.sidkathuria14.mapsclone.models.models_places.main_places;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 25/10/17.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {

    ArrayList<main_places> arrayList;
    Context context;

    public PlacesAdapter(ArrayList<main_places> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    public void getPlaces(ArrayList<main_places> MyArrayList){
        this.arrayList = MyArrayList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
