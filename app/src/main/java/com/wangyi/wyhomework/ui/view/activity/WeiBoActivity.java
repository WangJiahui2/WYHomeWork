package com.wangyi.wyhomework.ui.view.activity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sina.weibo.sdk.openapi.IWBAPI;

import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.present.IWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWeiBoCallBack;
import com.wangyi.wyhomework.ui.view.adapter.MyGridView;
import com.wangyi.wyhomework.utils.ACache;
import com.wangyi.wyhomework.utils.PresenterManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微博详情页的实现
 * https://api.weibo.com/2/comments/show.json?access_token=2.00Y9T87IJMhzkB66f58113630AHVce&id=4751602571542856
 * comments里的comment中的status里有原微博的信息
 * 也就是通过comments接口，就可以拿到微博完整的信息，直接进行展示即可。
 */
public class WeiBoActivity extends AppCompatActivity implements IWeiBoCallBack {

    private static final String APP_KY = "1610548341";
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    // TODO: 2022/3/20 SCOPE字段需要完善
    private static final String SCOPE = "48ac2b2a3948af9b7a291567150018e7";

    private IWBAPI mWBAPI;
    public static String mAccessToken;
    private long expiresTime;
    private ACache aCache;

    private IWeiBoPresenter weiBoPresenter;

    private String mWeiBoId;

    @BindView(R.id.avatar)
    public ImageView avatarIV;

    @BindView(R.id.send_name)
    public TextView sendNameTV;

    @BindView(R.id.send_time)
    public TextView sendTimeTV;

    @BindView(R.id.send_iphone)
    public TextView sendIphoneTV;

    @BindView(R.id.weibo_content)
    public TextView weiboContentTV;

    @BindView(R.id.weibo_one_pic)
    public ImageView weiboContentPic;


    @Nullable
    @BindView(R.id.weibo_gridview)
    public MyGridView weiboPicGv;

    @BindView(R.id.forward_number)
    public TextView forwardTv;

    @BindView(R.id.comments_number)
    public TextView commentTv;

    @BindView(R.id.goods_number)
    public TextView goodsTv;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo);
        ButterKnife.bind(this);
        initPresenter();
        mWeiBoId = getIntent().getStringExtra("id");
        getWeiBo();

    }

    private void getWeiBo() {
        weiBoPresenter.getWeiBoForId(LoginActivity.mAccessToken, mWeiBoId);
    }


    private void initView() {

    }

    private void initListener() {

    }

    private void initPresenter() {
        weiBoPresenter = PresenterManager.getInstance().getWeiBoPresenter();
        weiBoPresenter.registerViewCallback(this);
    }


    @Override
    public void onWeiBoLoaded(StatusesDTO statusesDTO) {
        
    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onEmpty() {

    }
}
