package com.wangyi.wyhomework.ui.callback;

import com.wangyi.wyhomework.common.IBaseCallBack;
import com.wangyi.wyhomework.model.comments.Comments;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;

public interface IWeiBoCallBack extends IBaseCallBack {
    
    void onWeiBoLoaded(Comments comments);
}
