package com.wangyi.wyhomework.ui.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.present.IWriteWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWriteWeiBoCallBack;
import com.wangyi.wyhomework.utils.PresenterManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteWeiBoActivity extends AppCompatActivity implements IWriteWeiBoCallBack {

    
    @BindView(R.id.cancel)
    public TextView cancleTv;
    
    @BindView(R.id.send_weibo)
    public TextView sendTv;
    
    @BindView(R.id.writer_weibo)
    public TextView weiboTv;


    private IWriteWeiBoPresenter mWritePresenter;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_weibo);
        ButterKnife.bind(this);
        initListener();
        
    }


    private void initListener() {
        cancleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        sendTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mWritePresenter != null){
                    mWritePresenter.postWeiBo(LoginActivity.mAccessToken, String.valueOf(sendTv.getText()));
                }
               
            }
        });
        
    }

    protected void initPresenter() {
        mWritePresenter = PresenterManager.getInstance().getWriteWeiBoPresenter();
        mWritePresenter.registerViewCallback(this);
    }

    @Override
    public void onWriteSuccess(StatusesDTO statusesDTO) {
        finish();
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
