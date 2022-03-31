package com.wangyi.wyhomework.common;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class MyApplication extends Application {

    
    public static  Context applicationContext;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();

    }
    
}

