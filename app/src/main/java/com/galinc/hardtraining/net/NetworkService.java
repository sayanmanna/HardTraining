package com.galinc.hardtraining.net;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    public static final String BASE_URL = "http://172.31.255.165/test/hs/api/";
    private Retrofit mRetrofit;

    private NetworkService(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor("guest", "guest"))
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance(){
        if (mInstance == null){
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public JSONPlaceHolderApi getJSONApi(){
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }
}