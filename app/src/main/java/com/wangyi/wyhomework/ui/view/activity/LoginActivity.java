package com.wangyi.wyhomework.ui.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.common.BaseFragment;
import com.wangyi.wyhomework.utils.ACache;
import com.wangyi.wyhomework.utils.LogUtils;
import com.wangyi.wyhomework.ui.view.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    
    private static final String APP_KY = "1610548341";
    private static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    // TODO: 2022/3/20 SCOPE字段需要完善
    private static final String SCOPE = "48ac2b2a3948af9b7a291567150018e7";

    private IWBAPI mWBAPI;
    public static String mAccessToken;
    private long  expiresTime;
    private ACache aCache;
    private int initSdkTimes = 0;

    @BindView(R.id.main_navigation_bar)
    public BottomNavigationView mNavigationView;

    private HomeFragment mHomeFragment;

    private FragmentManager mFragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initACache();
        initSdk();
    }


    private void initACache() {
        aCache = ACache.get(this);// 默认选择的路径是new File(context.getCacheDir(),// "ACache")
    }


    /**
     * sdk只初始化一次即可，先判断是否授权，
     * 如果已经有token数据，那么初始化ui就可以。
     */
    private void initSdk() {
        String cacheToken = aCache.getAsString("mAccessToken");
        if (cacheToken != null &&
                !cacheToken.isEmpty()) {
            mAccessToken = cacheToken;
            initView();
            initListener();
        } else {
            AuthInfo authInfo = new AuthInfo(this, APP_KY, REDIRECT_URL, SCOPE);
            mWBAPI = WBAPIFactory.createWBAPI(this); // 传Context即可，不再依赖于Activity
            mWBAPI.registerApp(this, authInfo, new SdkListener() {
                        @Override
                        public void onInitSuccess() {
                            // SDK初始化成功回调，成功⼀次后再次初始化将不再有任何回调
                            startAuth();
                        }

                        @Override
                        public void onInitFailure(Exception e) {
                            // SDK初始化失败回调
                            if (initSdkTimes < 5){
                                initSdk();
                                initSdkTimes++;
                            }
                        }
                    }
            );
        }
    }

    private void startAuth() {
        mWBAPI.authorize(this, new WbAuthListener() {
            @Override
            public void onComplete(Oauth2AccessToken oauth2AccessToken) {
                Toast.makeText(LoginActivity.this, "微博授权成功",
                        Toast.LENGTH_SHORT).show();
                mAccessToken = oauth2AccessToken.getAccessToken();
                expiresTime = oauth2AccessToken.getExpiresTime();
                aCache.put("mAccessToken", mAccessToken, ACache.TIME_DAY);
                initView();
                initListener();
            }

            @Override
            public void onError(UiError uiError) {
                Toast.makeText(LoginActivity.this, "微博授权出错",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this, "微博授权取消",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        initFragments();
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                LogUtils.d(this, "切换到首页");
                switchFragment(mHomeFragment);
            } 
            return true;
        });
    }

    private void initFragments() {
        mHomeFragment = new HomeFragment();
        mFragmentManager = getSupportFragmentManager();
        switchFragment(mHomeFragment);
    }

    /**
     * 上一个显示的fragment
     */
    private BaseFragment lastOneFragment = null;

    private void switchFragment(BaseFragment targetFragment) {
        if (targetFragment == lastOneFragment) {
            return;
        }

        //修改成add和hide的方式来控制Fragment的切换
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (!targetFragment.isAdded()) {
            fragmentTransaction.add(R.id.main_page_container, targetFragment);
        } else {
            fragmentTransaction.show(targetFragment);
        }
        if (lastOneFragment != null) {
            fragmentTransaction.hide(lastOneFragment);
        }
        lastOneFragment = targetFragment;
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mWBAPI != null) {
            mWBAPI.authorizeCallback(this, requestCode, resultCode, this.getIntent());
        }
    }


}
