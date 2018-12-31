package com.example.dell.androidramp_up.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Response data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response getData() {
        return data;
    }

    public void setData(Response data) {
        this.data = data;
    }
}
