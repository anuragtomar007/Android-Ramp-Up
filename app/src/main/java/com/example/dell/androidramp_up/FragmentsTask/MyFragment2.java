package com.example.dell.androidramp_up.FragmentsTask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.androidramp_up.R;

public class MyFragment2 extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment2, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            String message = getArguments().getString("Message");
            TextView tv_message = getView().findViewById(R.id.textViewFrag);
            tv_message.setText(message);
        }
    }
}
