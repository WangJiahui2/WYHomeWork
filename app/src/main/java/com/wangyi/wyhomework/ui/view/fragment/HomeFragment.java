package com.wangyi.wyhomework.ui.view.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.common.BaseFragment;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;
import com.wangyi.wyhomework.present.IHomePresenter;
import com.wangyi.wyhomework.ui.callback.IHomeCallBack;
import com.wangyi.wyhomework.ui.view.activity.LoginActivity;
import com.wangyi.wyhomework.ui.view.activity.WriteWeiBoActivity;
import com.wangyi.wyhomework.ui.view.adapter.HomeRecyclerViewAdapter;
import com.wangyi.wyhomework.utils.PresenterManager;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallBack, HomeRecyclerViewAdapter.OnListItemClickListener {

    @BindView(R.id.home_recyclerview)
    public RecyclerView mHomeRecyclerView;
    private HomeRecyclerViewAdapter mHomeAdapter;
    
    private IHomePresenter mHomePresenter;
    
    @BindView(R.id.writer_weibo)
    public ImageView  mWriteWeiBo; 
    

    @Override
    protected int getRootViewResId() {
        return R.layout.fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void initView(View rootView) {
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeAdapter = new HomeRecyclerViewAdapter();
        mHomeRecyclerView.setAdapter(mHomeAdapter);
        mHomeRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 10;
            }
        });
    }

    @Override
    protected void initListener() {
        mHomeAdapter.setOnListItemClickListener(this);
        mWriteWeiBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), WriteWeiBoActivity.class));
            }
        });
    }

    @Override
    protected void initPresenter() {
        mHomePresenter = PresenterManager.getInstance().getmHomePresenter();
        mHomePresenter.registerViewCallback(this);
        mHomePresenter.registerLifecycle(this);
//        mHomePresenter.createDataBase();
        mHomePresenter.createDataBaseN();
//        mHomePresenter.getWeiBoList(LoginActivity.mAccessToken);
 //       mHomePresenter.getWeiboForId(LoginActivity.mAccessToken.getAccessToken());
   
    }

    @Override
    public void onListLoaded(WeiBoList wbList) {
        mHomeAdapter.setData(wbList);
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
    
    // 原创微博的点击事件在这里处理
    @Override
    public void onOriginalItemClick(View view, StatusesDTO item) {
        
    }

    // 转发微博的点击事件在这里处理
    @Override
    public void onForwardItemClick(View view, StatusesDTO item) {
        
    }
}
