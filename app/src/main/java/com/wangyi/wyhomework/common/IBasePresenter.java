package com.wangyi.wyhomework.common;

public interface IBasePresenter<T> {

    /**
     * 注册ui通知接口
     * @param callBack
     */
    void registerViewCallback(T callBack);
    
    
    void unRegisterViewCallBack(T callBack);
    
}
