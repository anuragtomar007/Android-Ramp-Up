package com.example.dell.androidramp_up;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class CustomEndlessAdapter extends RecyclerView.Adapter<CustomEndlessAdapter.MyViewHolder> {
    private ArrayList<EndlessData> countries;

    public CustomEndlessAdapter(ArrayList countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.endless_row,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TextView name = myViewHolder.name;
        name.setText(countries.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_country);
        }

    }
}
