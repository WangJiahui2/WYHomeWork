package com.wangyi.wyhomework.ui.callback;

import com.wangyi.wyhomework.common.IBaseCallBack;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;

public interface IHomeCallBack extends IBaseCallBack {
    
    void onListLoaded(WeiBoList wbList);
}
