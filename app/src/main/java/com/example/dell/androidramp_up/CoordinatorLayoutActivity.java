package com.example.dell.androidramp_up;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
    }

    public static class Device {
        @SerializedName("deviceType")
        @Expose
        private String deviceType;

        @SerializedName("deviceId")
        @Expose
        private String deviceId;

        @SerializedName("deviceOsVersion")
        @Expose
        private String deviceOsVersion;

        public String getDeviceType() {
            return deviceType;
        }

        public String getDeviceOsVersion() {
            return deviceOsVersion;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public void setDeviceOsVersion(String deviceOsVersion) {
            this.deviceOsVersion = deviceOsVersion;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }
    }
}
