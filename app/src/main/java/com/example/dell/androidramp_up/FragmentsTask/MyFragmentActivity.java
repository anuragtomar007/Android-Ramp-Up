package com.example.dell.androidramp_up.FragmentsTask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.androidramp_up.R;

import java.util.Objects;

public class MyFragmentActivity extends AppCompatActivity implements MyFragmentInterface {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout1, new MyFragment(), "First");
        ft.replace(R.id.frameLayout2, new MyFragment2(), "Second");
        ft.commit();

        final EditText ev_Message = findViewById(R.id.et_message);
        Button sendMessage = findViewById(R.id.sendBtn);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = ev_Message.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Message", message);
                MyFragment2 myFragment2 = new MyFragment2();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout2, myFragment2, "Second");
//                ft.addToBackStack("check 2");
//                Toast.makeText(MyFragmentActivity.this, "Check 2", Toast.LENGTH_SHORT).show();
                ft.commit();
                myFragment2.setArguments(bundle);
            }
        });
    }

    @Override
    public void sentFromFragment(String string) {
//        For Passing the data to Another Fragment
        FragmentManager fm = getSupportFragmentManager();
        TextView name = Objects.requireNonNull(Objects.requireNonNull(fm.findFragmentByTag("Second")).getView()).findViewById(R.id.textViewFrag);
        name.setText(string);

//        For Passing the data to its Host Activity
//        TextView textView = findViewById(R.id.text);
//        textView.setVisibility(View.VISIBLE);
//        textView.setText(string);
    }
}
