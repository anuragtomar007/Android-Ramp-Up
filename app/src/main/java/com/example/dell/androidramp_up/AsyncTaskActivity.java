package com.example.dell.androidramp_up;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        time = findViewById(R.id.in_time);
        Button button = findViewById(R.id.btn_run);
        finalResult = findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask runner = new MyAsyncTask();
                String sleepTime = time.getText().toString();
                runner.execute(sleepTime);
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {

            try {
                int time = Integer.parseInt(params[0]);
                for (int i = 0; i < time; i++) {
                    publishProgress("" + (time - i));
                    Thread.sleep(1000);
                }
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            finalResult.setText(result);
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(AsyncTaskActivity.this, "ProgressDialog", "Wait for " + time.getText().toString() + " seconds");
        }

        @Override
        protected void onProgressUpdate(String... text) {
            progressDialog.setMessage("Wait for " + text[0] + " seconds");
            finalResult.setText(text[0]);
        }
    }
}
