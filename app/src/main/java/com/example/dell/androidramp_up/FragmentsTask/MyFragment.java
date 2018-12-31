package com.example.dell.androidramp_up.FragmentsTask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.androidramp_up.R;

public class MyFragment extends Fragment {
    MyFragmentInterface fragmentInterface;
    private String TAG = "MyFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (MyFragmentInterface) context;
        Log.d(TAG, "Inside onAttach of Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate of Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_fragment, container, false);
        Log.d(TAG, "Inside onCreateView of Fragment");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "Inside onViewCreated of Fragment");
        final EditText fragText = view.findViewById(R.id.frag_text);
        Button btn = view.findViewById(R.id.fragBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = fragText.getText().toString();
                fragmentInterface.sentFromFragment(data);
            }
        });

        Button toActivity = view.findViewById(R.id.fragToActivityBtn);
        toActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = fragText.getText().toString();
                Intent intent = new Intent(getContext(), FragmentDataActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Inside onActivity of Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside onStart of Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside onResume of Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside onPause of Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside onStop of Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "Inside onDestroyView of Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside onDestroy of Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Inside onDetach of Fragment");
    }
}
