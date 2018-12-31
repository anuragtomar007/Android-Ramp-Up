package com.example.dell.androidramp_up.FragmentsTask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dell.androidramp_up.R;

public class FragmentDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_data);

        TextView getText = findViewById(R.id.tv_getData);
        getText.setText(getIntent().getStringExtra("data"));
    }
}
