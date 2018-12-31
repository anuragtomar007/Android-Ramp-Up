package com.example.dell.androidramp_up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DataTransferActivity extends AppCompatActivity {
    TextView tv_name, tv_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_transfer);
        tv_name = findViewById(R.id.tv_userName);
        tv_number = findViewById(R.id.tv_userNumber);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("Name");
        int number = bundle.getInt("Number");

//        For Passing data as Parcelable
//        Student student = (Student) getIntent().getParcelableExtra("parcel_data");
//        String name = student.getName();
//        int number = student.getMarks();

        tv_name.setText(name);
        tv_number.setText(String.valueOf(number));


    }
}
