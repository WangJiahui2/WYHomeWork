package com.wangyi.wyhomework.present.impl;

import com.alibaba.fastjson.JSON;
import com.wangyi.wyhomework.model.show.Weibo;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.net.api.IWeiboApi;
import com.wangyi.wyhomework.present.IWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWeiBoCallBack;
import com.wangyi.wyhomework.utils.RetrofitManager;

import java.util.Arrays;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeiBoPresenterImpl implements IWeiBoPresenter {

    private IWeiBoCallBack mWeiBoCallBack;
    

    @Override
    public void getWeiBoForId(String accessToken,String id) {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        IWeiboApi iWeiboApi = retrofit.create(IWeiboApi.class);
        String wbId = "4746981950102627";
        Call<ResponseBody> task = iWeiboApi.getWeiBoForId(accessToken, wbId);
        task.enqueue(new Callback<ResponseBody>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                assert response.body() != null;
                String res = Arrays.toString(response.body().bytes());
                StatusesDTO dto = JSON.parseObject(res, StatusesDTO.class);
                mWeiBoCallBack.onWeiBoLoaded(dto);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        
    }

    @Override
    public void registerViewCallback(IWeiBoCallBack callBack) {
        this.mWeiBoCallBack = callBack;
    }

    @Override
    public void unRegisterViewCallBack(IWeiBoCallBack callBack) {
        this.mWeiBoCallBack = null;
    }
}
