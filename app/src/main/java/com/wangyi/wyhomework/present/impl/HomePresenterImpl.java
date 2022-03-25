package com.wangyi.wyhomework.present.impl;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.alibaba.fastjson.JSON;
import com.wangyi.wyhomework.cache.AppDatabase;
import com.wangyi.wyhomework.cacheN.AppDatabaseN;
import com.wangyi.wyhomework.cacheN.WeiBoCacheN;
import com.wangyi.wyhomework.common.MyApplication;
import com.wangyi.wyhomework.model.show.Weibo;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;
import com.wangyi.wyhomework.net.api.IWeiboApi;
import com.wangyi.wyhomework.present.IHomePresenter;
import com.wangyi.wyhomework.ui.callback.IHomeCallBack;
import com.wangyi.wyhomework.ui.view.fragment.HomeFragment;
import com.wangyi.wyhomework.utils.ConvertDateBaseToVo;
import com.wangyi.wyhomework.utils.ConvertVoToDateBase;
import com.wangyi.wyhomework.utils.RetrofitManager;

import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter {


    private IHomeCallBack mCallBack = null;
    private WeiBoList wbList;
    private AppDatabase database;
    private AppDatabaseN databaseN;
    //判断缓存数据是否可用
    private boolean available = false;

    private HomeFragment mHomeFragment;
    //用于子线程与主线程之间异步通信
    private MutableLiveData<String> simpleLiveData;

    private final String NOCACHE = "no";

    private final String CACHE = "yes";
    
    private boolean firstLoad = true;
    
    private static final String LOG_TAG = "HomePresenterImpl";

    @Override
    public void registerViewCallback(IHomeCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    public void unRegisterViewCallBack(IHomeCallBack callBack) {

    }

    @Override
    public void createDataBaseN() {
        //创建数据库
        databaseN = Room.databaseBuilder(MyApplication.applicationContext,
                AppDatabaseN.class, "database_namen")
                .build();

        GetThreadN getThread = new GetThreadN();
        getThread.start();
        
    }



    public void createDataBase() {
        //创建数据库
        database = Room.databaseBuilder(MyApplication.applicationContext,
                AppDatabase.class, "database_name")
                .build();


    }

    @Override
    public void registerLifecycle(HomeFragment homeFragment) {
        mHomeFragment = homeFragment;
    }

    @Override
    public void getWeiboForId(String accessToken) {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        IWeiboApi iWeiboApi = retrofit.create(IWeiboApi.class);
        String wbId = "4746981950102627";
        Call<Weibo> task = iWeiboApi.getWeiboForId(accessToken, wbId);
        task.enqueue(new Callback<Weibo>() {
            @Override
            public void onResponse(Call<Weibo> call, Response<Weibo> response) {
                Weibo weibo = response.body();
            }

            @Override
            public void onFailure(Call<Weibo> call, Throwable t) {

            }
        });


    }


    @Override
    public void getWeiBoList(String accessToken) {
        if (firstLoad){
            firstLoad(accessToken);
            firstLoad = false;
        }else{
            loadList(accessToken);
        }
    }

    private void firstLoad(String accessToken) {
        simpleLiveData = new MutableLiveData<>();
        checkCacheAvailable();
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String text) {
                if (text.equals(CACHE)) {
                    if (mCallBack != null) {
                        mCallBack.onListLoaded(wbList);
                    }
                }
                if (text.equals(NOCACHE)) {
                    loadList(accessToken);
                }
            }
        };
        simpleLiveData.observe(mHomeFragment.getViewLifecycleOwner(), observer);
    }

    private void loadList(String accessToken) {
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        IWeiboApi iWeiboApi = retrofit.create(IWeiboApi.class);
        Call<ResponseBody> task = iWeiboApi.getWeiboList(accessToken);
        task.enqueue(new Callback<ResponseBody>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    String jsonStr = new String(response.body().bytes());
                    wbList = JSON.parseObject(jsonStr, WeiBoList.class);
                    if (mCallBack != null) {
                        if (wbList != null) {
                            mCallBack.onListLoaded(wbList);
                            new UpdateThread().start();
                        }
                    }
                } else {

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("AAA");
            }
        });
    }


    private void checkCacheAvailable() {
//        wbList = new ConvertDateBaseToVo().convert(database.weiBoDao().getAll());
        GetThread getThread = new GetThread();
        getThread.start();
    }


    public class GetThread extends Thread {
        @Override
        public void run() {
            wbList = new ConvertDateBaseToVo().convert(database.weiBoDao().getAll());
            if (wbList != null && wbList.getStatuses() != null &&
                    wbList.getStatuses().size() != 0) {
                //可用 
                simpleLiveData.postValue(CACHE);
            } else {
                //执行网络请求 
                simpleLiveData.postValue(NOCACHE);
            }
        }
    }


    public class UpdateThread extends Thread {
        @Override
        public void run() {
            if (wbList != null && wbList.getStatuses() != null &&
                    wbList.getStatuses().size() != 0) {
                //数据正确，更新。
                database.weiBoDao().insertWeiBo(new ConvertVoToDateBase().convert(wbList));
                int updateNumber = database.weiBoDao().updateWeiBo(new ConvertVoToDateBase().convert(wbList));
                Log.i(LOG_TAG,"更新了" + updateNumber);
            } else {
                
            }
        }
    }


    public class GetThreadN extends Thread {
        @Override
        public void run() {
            WeiBoCacheN weiBoCacheN = new WeiBoCacheN(0,"AAA");
           databaseN.weiBoDaoN().insertWeiBo(weiBoCacheN);
        }
    }


}
