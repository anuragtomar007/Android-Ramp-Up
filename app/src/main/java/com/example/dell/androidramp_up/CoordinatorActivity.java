package com.example.dell.androidramp_up;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CoordinatorActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    Button showSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        showSnackbar = findViewById(R.id.btn_snackbar);
        coordinatorLayout = findViewById(R.id.myCoordinator);
        showSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "This is Anurag's Snackbar for displaying the Co-ordinator layout functionality", Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
