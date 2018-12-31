package com.example.dell.androidramp_up;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeDetails extends AppCompatActivity implements CustomAdapter.MyInterface {
    private static RecyclerView.Adapter adapter;
    private static ArrayList<DataModel> data;
    TextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        Button sort = findViewById(R.id.btn_sort);
        check = findViewById(R.id.tv_check);
        Toolbar toolbar = findViewById(R.id.toolbar_emp);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.emp_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.smoothScrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(MyData.nameArray[i], MyData.designationArray[i], MyData.empId[i]));
        }
        adapter = new CustomAdapter(data, this);
        ((CustomAdapter) adapter).setMyInterface(this);
        recyclerView.setAdapter(adapter);

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(data, new Comparator<DataModel>() {
                    @Override
                    public int compare(DataModel o1, DataModel o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                adapter.notifyDataSetChanged();
                Toast.makeText(EmployeeDetails.this, "Sort Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addEmp) {
            data.add(new DataModel("New Employee", "New Joinee", "not assigned"));
            adapter.notifyDataSetChanged();
            Toast.makeText(EmployeeDetails.this, "New Employee Added", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.delEmp) {
            int lastIndex = data.size() - 1;
            data.remove(lastIndex);//need to pass the last index
            adapter.notifyDataSetChanged();
            Toast.makeText(EmployeeDetails.this, "Last Employee Deleted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onClickRecycler(Context context, int position) {
        check.setText(data.get(position).getName());
    }
}
