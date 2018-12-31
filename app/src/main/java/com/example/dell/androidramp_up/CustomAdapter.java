package com.example.dell.androidramp_up;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    Context context;
    Activity activity;
    MyInterface myInterface;

    public interface MyInterface {
        void onClickRecycler(Context context, int position);
    }

    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    public CustomAdapter(ArrayList<DataModel> dataSet, Activity myActivity) {
        this.dataSet = dataSet;
//        this.context = context;
        this.activity = myActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        TextView name = myViewHolder.name;
        TextView designation = myViewHolder.designation;
        TextView empId = myViewHolder.empId;
        CardView cardView = myViewHolder.cardView;
        Button seeDetails = myViewHolder.seeDetails;

        name.setText(dataSet.get(i).getName());
        designation.setText(dataSet.get(i).getDesignation());
        empId.setText(dataSet.get(i).getEmpId());
        activity.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Uncomment the lines", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,DetailEmployeeActivity.class);
//                intent.putExtra("Name",dataSet.get(myViewHolder.getAdapterPosition()).getName());
//                intent.putExtra("Designation",dataSet.get(myViewHolder.getAdapterPosition()).getDesignation());
//                intent.putExtra("Id",dataSet.get(myViewHolder.getAdapterPosition()).getEmpId());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });

        seeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailEmployeeActivity.class);
                intent.putExtra("Name", dataSet.get(myViewHolder.getAdapterPosition()).getName());
                intent.putExtra("Designation", dataSet.get(myViewHolder.getAdapterPosition()).getDesignation());
                intent.putExtra("Id", dataSet.get(myViewHolder.getAdapterPosition()).getEmpId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myInterface.onClickRecycler(context, myViewHolder.getAdapterPosition());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView designation;
        TextView empId;
        Button seeDetails;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_emp_name);
            designation = itemView.findViewById(R.id.tv_designation);
            empId = itemView.findViewById(R.id.tv_emp_id);
            cardView = itemView.findViewById(R.id.cardView);

            seeDetails = itemView.findViewById(R.id.btn_detailEmp);

        }
    }
}
