package com.wangyi.wyhomework.present;

import com.wangyi.wyhomework.common.IBasePresenter;
import com.wangyi.wyhomework.ui.callback.IHomeCallBack;
import com.wangyi.wyhomework.ui.callback.IWriteWeiBoCallBack;
import com.wangyi.wyhomework.ui.view.fragment.HomeFragment;

public interface IWriteWeiBoPresenter extends IBasePresenter<IWriteWeiBoCallBack> {

   
    void postWeiBo(String accessToken,String status);

}
