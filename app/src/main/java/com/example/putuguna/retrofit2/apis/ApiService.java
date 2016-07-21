package com.example.putuguna.retrofit2.apis;

import com.example.putuguna.retrofit2.models.Profile;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by putuguna on 14/06/16.
 */
public interface ApiService {
    @GET("myself")
    Call<Profile> getMyProfile(@Query("id") String id);
}
