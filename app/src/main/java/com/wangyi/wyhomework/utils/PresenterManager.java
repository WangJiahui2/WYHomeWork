package com.wangyi.wyhomework.utils;

import com.wangyi.wyhomework.present.IHomePresenter;
import com.wangyi.wyhomework.present.impl.HomePresenterImpl;

public class PresenterManager {
    
    private final IHomePresenter mHomePresenter;
    private static final PresenterManager instance = new PresenterManager();



    public static PresenterManager getInstance() {
        return instance;
    }
    
    private PresenterManager(){
        mHomePresenter = new HomePresenterImpl();
    }


    public IHomePresenter getmHomePresenter() {
        return mHomePresenter;
    }
}
