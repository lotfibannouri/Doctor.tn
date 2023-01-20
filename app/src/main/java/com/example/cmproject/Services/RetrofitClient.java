package com.example.cmproject.Services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit ;

    public static Retrofit getInstanceRetrofit (){
        if (retrofit == null ){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();
            retrofit = new Retrofit.Builder().
                    baseUrl("http://10.10.10.30:7271/api/").
                    addConverterFactory(GsonConverterFactory.create()).
                    client(client).
                    build();
        }
        return retrofit ;
    }


}
