package com.wangyi.wyhomework.present;

import com.wangyi.wyhomework.common.IBasePresenter;
import com.wangyi.wyhomework.ui.callback.IHomeCallBack;
import com.wangyi.wyhomework.ui.view.fragment.HomeFragment;

public interface IHomePresenter extends IBasePresenter<IHomeCallBack> {

    /**
     * 获取当前账户微博
     */
    void getWeiBoList(String accessToken);

    void getWeiboForId(String accessToken);

    void createDataBase();

    void createDataBaseN();
    
    void registerLifecycle(HomeFragment homeFragment);
}
