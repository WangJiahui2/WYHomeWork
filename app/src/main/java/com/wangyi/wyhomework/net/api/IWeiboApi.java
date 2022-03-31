package com.wangyi.wyhomework.net.api;



import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IWeiboApi {
    

    //通过id获得微博评论，此接口同时也会返回微博详情，组合即可获得完整微博。
    @GET("2/comments/show.json")
    Call<ResponseBody> getWeiBoForId(@Query("access_token") String accessToken,
                              @Query("id") String id);
    //关注的人的微博流
    @GET("2/statuses/home_timeline.json")
    Call<ResponseBody> getWeiBoList(@Query("access_token") String accessToken);

    /**
     * 用户分享到微博的文本内容，必须做URLencode处理
     * 
     * @param accessToken
     * @param status
     * @return
     */
    @POST("2/statuses/share.json")
    Call<ResponseBody> postWeiBo(@Query("access_token") String accessToken
        , @Field("status") String status);
    
    
}
