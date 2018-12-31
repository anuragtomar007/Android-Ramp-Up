package com.example.dell.androidramp_up.Networking;

import retrofit.RestAdapter;

public class DeviceAPI {
    public static DeviceInterface getClient() {

        String BASE_URL = "https://api.flexyapp.com";

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();

//        Retrofit adapter = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        DeviceInterface api = adapter.create(DeviceInterface.class);
        return api;
    }
}
