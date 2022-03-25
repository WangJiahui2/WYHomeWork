package com.wangyi.wyhomework.net.api;

import com.wangyi.wyhomework.model.show.Weibo;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;

import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeiboApi {
    


    @GET("2/statuses/show.json")
    Call<Weibo> getWeiboForId(@Query("access_token") String accessToken,
                              @Query("id") String id);

    @GET("2/statuses/home_timeline.json")
    Call<ResponseBody> getWeiboList(@Query("access_token") String accessToken);

    
}
