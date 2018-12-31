package com.example.dell.androidramp_up;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_employee);
        TextView name = findViewById(R.id.tv_emp_name);
        TextView designation = findViewById(R.id.tv_designation);
        TextView empId = findViewById(R.id.tv_emp_id);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name.setText(bundle.getString("Name"));
            designation.setText(bundle.getString("Designation"));
            empId.setText(bundle.getString("Id"));
        }
    }
}
