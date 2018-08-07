package com.example.analistasistemas.pruebasqllte.adapters;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MobicobApiAdapter {

    private static MobicobApiServices API_SERVICES;

    public static MobicobApiServices getApiServices(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient= new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        String baseUrl = "http://192.168.1.14:3000/v1/";

        if (API_SERVICES == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            API_SERVICES = retrofit.create(MobicobApiServices.class);
        }
        return API_SERVICES;
    }
}

