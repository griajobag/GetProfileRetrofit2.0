package com.example.putuguna.retrofit2.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by putuguna on 14/06/16.
 */
public class ApiClient {
    public static final String BASE_URL = "http://private-fc41f-myprofile2.apiary-mock.com/";
    public static Retrofit retrofit= null;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
