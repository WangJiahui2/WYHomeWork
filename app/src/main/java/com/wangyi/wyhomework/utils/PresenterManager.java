package com.wangyi.wyhomework.utils;

import com.wangyi.wyhomework.present.IHomePresenter;
import com.wangyi.wyhomework.present.IWeiBoPresenter;
import com.wangyi.wyhomework.present.IWriteWeiBoPresenter;
import com.wangyi.wyhomework.present.impl.HomePresenterImpl;
import com.wangyi.wyhomework.present.impl.WeiBoPresenterImpl;
import com.wangyi.wyhomework.present.impl.WriteWeiBoPresenterImpl;

public class PresenterManager {
    
    private final IHomePresenter mHomePresenter;
    private static final PresenterManager instance = new PresenterManager();
    private final IWriteWeiBoPresenter mWriteWeiBoPresenter;
    private final IWeiBoPresenter mWeiBoPresenter;

    public static PresenterManager getInstance() {
        return instance;
    }
    
    private PresenterManager(){
        mHomePresenter = new HomePresenterImpl();
        mWriteWeiBoPresenter = new WriteWeiBoPresenterImpl();
        mWeiBoPresenter = new WeiBoPresenterImpl();
    }


    public IHomePresenter getHomePresenter() {
        return mHomePresenter;
    }

    public IWriteWeiBoPresenter getWriteWeiBoPresenter() {
        return mWriteWeiBoPresenter;
    }

    public IWeiBoPresenter getWeiBoPresenter() {
        return mWeiBoPresenter;
    }
}
