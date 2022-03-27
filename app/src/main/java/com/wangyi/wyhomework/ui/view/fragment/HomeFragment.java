package com.wangyi.wyhomework.ui.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.common.BaseFragment;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;
import com.wangyi.wyhomework.present.IHomePresenter;
import com.wangyi.wyhomework.ui.callback.IHomeCallBack;
import com.wangyi.wyhomework.ui.view.activity.LoginActivity;
import com.wangyi.wyhomework.ui.view.activity.WeiBoActivity;
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
    public ImageView mWriteWeiBo;

    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout refreshLayout;

    private AlertDialog dialog;

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
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE);
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
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHomePresenter.getWeiBoList(LoginActivity.mAccessToken);
            }
        });
    }

    @Override
    protected void initPresenter() {
        mHomePresenter = PresenterManager.getInstance().getHomePresenter();
        mHomePresenter.registerViewCallback(this);
        mHomePresenter.registerLifecycle(this);
        mHomePresenter.createDataBase();
        mHomePresenter.getWeiBoList(LoginActivity.mAccessToken);
        //       mHomePresenter.getWeiboForId(LoginActivity.mAccessToken.getAccessToken());

    }

    @Override
    public void onListLoaded(WeiBoList wbList) {
        //如果是使用下拉刷新控件进行的网络请求，那么要停止刷新。
        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onOriginalItemClick(View view, StatusesDTO itemBean) {
        //点击图片展示大图，以及关闭大图。

        switch (view.getId()) {
            case R.id.weibo_one_pic:
                
            case R.id.weibo_content:
//                Intent intent = new Intent(getContext(), WeiBoActivity.class);
//                intent.putExtra("id",itemBean.getId());
//                startActivity(intent);
                break;



        }

    }

    // 转发微博的点击事件在这里处理
    @Override
    public void onForwardItemClick(View view, StatusesDTO item) {
        
    }
}
