package com.example.dell.androidramp_up;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.androidramp_up.FragmentsTask.Fragment1;
import com.example.dell.androidramp_up.FragmentsTask.Fragment2;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Fragment fragment = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.frag1,fragment).commit();
        Fragment fragment2 = new Fragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.frag2, fragment2).commit();
    }
}
