package com.wangyi.wyhomework.utils;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final RetrofitManager ourInstance = new RetrofitManager();
    private final Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        return ourInstance;
    }
    
    private RetrofitManager(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.STATUS_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }


    /*
     **打印retrofit信息部分
     */
    public HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.e("RetrofitLog","retrofitBack = "+message);
        }
    });

    OkHttpClient client = new OkHttpClient.Builder()//okhttp设置部分，此处还可再设置网络参数
            .addInterceptor(loggingInterceptor)
            .build();
}
