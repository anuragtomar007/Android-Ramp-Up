package com.example.dell.androidramp_up;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_message);
        Button submit = findViewById(R.id.submit);
        final EditText message = findViewById(R.id.et_message);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myMessage = message.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Message", myMessage);
                setResult(2, intent);
                finish();
            }
        });

        GetMessageActivity.this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
