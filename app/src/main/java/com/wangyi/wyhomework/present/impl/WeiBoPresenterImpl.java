package com.wangyi.wyhomework.present.impl;

import com.alibaba.fastjson.JSON;
import com.wangyi.wyhomework.model.comments.Comments;
import com.wangyi.wyhomework.net.api.IWeiboApi;
import com.wangyi.wyhomework.present.IWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWeiBoCallBack;
import com.wangyi.wyhomework.utils.RetrofitManager;


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
        Call<ResponseBody> task = iWeiboApi.getWeiBoForId(accessToken, id);
        task.enqueue(new Callback<ResponseBody>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                assert response.body() != null;
//                String body = Arrays.toString(response.body().bytes());

                String res = new String(response.body().bytes());

                
//                String body = JSONObject.toJSONString(response);
//                Object parse1 = JSON.parse(body);
//                String s = parse1.toString();
//                Comments comments = JSONObject.parseObject(s, Comments.class);
                Comments comments = JSON.parseObject(res, Comments.class);
                mWeiBoCallBack.onWeiBoLoaded(comments);
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
