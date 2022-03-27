package com.wangyi.wyhomework.ui.callback;

import com.wangyi.wyhomework.common.IBaseCallBack;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;

public interface IWriteWeiBoCallBack extends IBaseCallBack {

    void onWriteSuccess(StatusesDTO statusesDTO);
}
