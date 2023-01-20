package com.example.cmproject.Services;

import com.example.cmproject.Models.Auth;
import com.example.cmproject.Models.Registration;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("Compte/Inscription")
    Call<ResponseBody> Registrated(@Body Registration registration);
    @POST("Compte/auth")
    Call<ResponseBody> Authentication(@Body Auth login) ;


}
