package com.example.dell.androidramp_up;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
 public String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG,"Inside OnCreate() Method of SecondActivity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Inside OnStart() Method of SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Inside OnResume() Method of SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Inside OnPause() Method of SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Inside OnStop() Method of SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Inside OnRestart() Method of SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Inside OnDestroy() Method of SecondActivity");
    }

}
