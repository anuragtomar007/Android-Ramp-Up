package com.example.dell.androidramp_up.Networking;

public class Device {
    private int deviceType;
    private int deviceId;
    private int deviceOsVersion;

    public int getDeviceType() {
        return deviceType;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public int getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setDeviceOsVersion(int deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }
}
