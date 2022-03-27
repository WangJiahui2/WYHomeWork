package com.wangyi.wyhomework.present;

import com.wangyi.wyhomework.common.IBasePresenter;
import com.wangyi.wyhomework.ui.callback.IWeiBoCallBack;

public interface IWeiBoPresenter extends IBasePresenter<IWeiBoCallBack> {


    void getWeiBoForId(String accessToken,String id);
}
