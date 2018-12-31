package com.example.dell.androidramp_up.Networking;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface DeviceInterface {
    @FormUrlEncoded
    @Headers("language:en")
    @POST("/guest/signIn")
    void registration(@Field("deviceType") String deviceType,
                      @Field("deviceId") String deviceId,
                      @Field("deviceOsVersion") String deviceOsVersion,
                      Callback<Device> callback);
}
