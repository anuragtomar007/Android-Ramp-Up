package com.example.dell.androidramp_up.ComponentsTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.androidramp_up.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = ServiceActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Toolbar toolbar = findViewById(R.id.serviceToolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(TAG);

        Button startService = findViewById(R.id.startService);
        Button stopService = findViewById(R.id.stop_service);

        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startService:
                Intent intent = new Intent(ServiceActivity.this, MyService.class);
                Toast.makeText(this, "Starting Service", Toast.LENGTH_SHORT).show();
                startService(intent);
                break;
            case R.id.stop_service:
                Intent intent1 = new Intent(ServiceActivity.this, MyService.class);
                Toast.makeText(this, "Stopping Service", Toast.LENGTH_SHORT).show();
                stopService(intent1);
        }
    }
}
