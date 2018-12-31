package com.example.dell.androidramp_up.Networking;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.androidramp_up.R;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PostRetrofitActivity extends AppCompatActivity {
    private EditText deviceType;
    private EditText deviceId;
    private EditText deviceOsVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_retrofit);
        deviceType = findViewById(R.id.deviceType);
        deviceId = findViewById(R.id.deviceId);
        deviceOsVersion = findViewById(R.id.deviceOsVersion);
        Button submit = findViewById(R.id.sendData);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(deviceType) && validate(deviceId) && validate(deviceOsVersion)) {
                    sendData();
                }
            }
        });
    }

    private void sendData() {
        final ProgressDialog progressDialog = new ProgressDialog(PostRetrofitActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        DeviceAPI.getClient().registration(deviceType.getText().toString().trim(),
                deviceId.getText().toString().trim(),
                deviceOsVersion.getText().toString().trim(), new Callback<Device>() {
                    @Override
                    public void success(Device device, Response response) {
                        progressDialog.dismiss();
                        Toast.makeText(PostRetrofitActivity.this, "Success :" + response.getBody().toString(), Toast.LENGTH_SHORT).show();
                        Log.d("Device", "Success : " + response.getBody().toString());
                        Toast.makeText(PostRetrofitActivity.this, "Status of call :" + response.getStatus(), Toast.LENGTH_SHORT).show();
                        Example example = new Example();
                        example.setMessage(response.getReason());
                        Toast.makeText(PostRetrofitActivity.this, "Message Status :" + example.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(PostRetrofitActivity.this, "Error Found " + error.toString(), Toast.LENGTH_LONG).show();
                        Log.d("Device", "Error :" + error.toString());
                        progressDialog.dismiss();
                    }
                });
    }

    private boolean validate(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return true;
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }
}
