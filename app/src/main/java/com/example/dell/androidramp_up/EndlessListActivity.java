package com.example.dell.androidramp_up;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class EndlessListActivity extends AppCompatActivity {
    ProgressBar progressBar;
    private ArrayList<EndlessData> employeeName;
    private RecyclerView.Adapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless_list);
        setTitle("Endless Recycler View");
        employeeName = new ArrayList<>();
        initData();
        progressBar = findViewById(R.id.progress_bar);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapter = new CustomEndlessAdapter(employeeName);
        recyclerView.setAdapter(customAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void loadMore() {
                addDataToList();
            }
        });
    }

    public void addDataToList() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 12; j++) {
                    employeeName.add(new EndlessData(EndlessDataLoader.nameArray[j]));
                }
                customAdapter.notifyDataSetChanged();
                Toast.makeText(EndlessListActivity.this, "List Updated", Toast.LENGTH_SHORT).show();
            }
        }, 1500);
    }

    public void initData() {
        for (int i = 0; i < 12; i++) {
            employeeName.add(new EndlessData(EndlessDataLoader.nameArray[i]));
        }
    }
}
