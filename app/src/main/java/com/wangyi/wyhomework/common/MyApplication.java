package com.wangyi.wyhomework.common;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class MyApplication extends Application {

    private static final String APP_KY = "1610548341";
    private static final String REDIRECT_URL = "https%3A%2F%2Fapi.weibo.com%2Foauth2%2Fdefault.html";
    private static final String SCOPE = "48ac2b2a3948af9b7a291567150018e7";
    public static  Context applicationContext;
    public static IWBAPI mWBAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();

    }
    
    private void initSdk() {
        AuthInfo authInfo = new AuthInfo(this, APP_KY, REDIRECT_URL, SCOPE);
        mWBAPI = WBAPIFactory.createWBAPI(this); // 传Context即可，不再依赖于Activity
        mWBAPI.registerApp(this, authInfo, new SdkListener() {
            @Override
            public void onInitSuccess() {
                // SDK初始化成功回调，成功⼀次后再次初始化将不再有任何回调
                Toast.makeText(MyApplication.this, "微博sdk初始化成功",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInitFailure(Exception e) {
                // SDK初始化失败回调
                Toast.makeText(MyApplication.this, "微博sdk初始化失败",
                        Toast.LENGTH_SHORT).show();
            }
        }
        );
    }



}

