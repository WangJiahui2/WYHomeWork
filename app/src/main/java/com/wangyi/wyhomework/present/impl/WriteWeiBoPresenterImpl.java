package com.wangyi.wyhomework.present.impl;

import com.alibaba.fastjson.JSON;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.net.api.IWeiboApi;
import com.wangyi.wyhomework.present.IWriteWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWriteWeiBoCallBack;
import com.wangyi.wyhomework.utils.RetrofitManager;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WriteWeiBoPresenterImpl implements IWriteWeiBoPresenter {
   
    private IWriteWeiBoCallBack mWriteCallBack;
   
    @Override
    public void postWeiBo(String accessToken, String status) {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        IWeiboApi iWeiboApi = retrofit.create(IWeiboApi.class);
        Call<ResponseBody> responseBodyCall = iWeiboApi.postWeiBo(accessToken, status);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String body = new String(response.body().bytes());
                StatusesDTO statusesDTO = JSON.parseObject(body, StatusesDTO.class);
                mWriteCallBack.onWriteSuccess(statusesDTO);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mWriteCallBack.onError();
            }
        });
    }

    @Override
    public void registerViewCallback(IWriteWeiBoCallBack callBack) {
        this.mWriteCallBack = callBack;
    }

    @Override
    public void unRegisterViewCallBack(IWriteWeiBoCallBack callBack) {
        this.mWriteCallBack = null;
    }
}
