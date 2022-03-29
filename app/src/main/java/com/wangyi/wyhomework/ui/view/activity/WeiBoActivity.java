package com.wangyi.wyhomework.ui.view.activity;


import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.common.CalculateTime;
import com.wangyi.wyhomework.model.comments.Comments;
import com.wangyi.wyhomework.model.comments.CommentsDTO;
import com.wangyi.wyhomework.model.comments.StatusDTO;
import com.wangyi.wyhomework.present.IWeiBoPresenter;
import com.wangyi.wyhomework.ui.callback.IWeiBoCallBack;
import com.wangyi.wyhomework.ui.view.adapter.CommentRecyclerViewAdapter;
import com.wangyi.wyhomework.common.MyGridView;
import com.wangyi.wyhomework.ui.view.adapter.MyGridViewAdapter;
import com.wangyi.wyhomework.utils.ParseHref;
import com.wangyi.wyhomework.utils.PresenterManager;
import com.wangyi.wyhomework.utils.SizeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 微博详情页的实现
 * https://api.weibo.com/2/comments/show.json?access_token=2.00Y9T87IJMhzkB66f58113630AHVce&id=4751602571542856
 * comments里的comment中的status里有原微博的信息
 * 也就是通过comments接口，就可以拿到微博完整的信息，直接进行展示即可。
 */
public class WeiBoActivity extends AppCompatActivity implements IWeiBoCallBack {
    
    private IWeiBoPresenter weiBoPresenter;

    private String mWeiBoId;

    private List<CommentsDTO> commentList;
    
    private StatusDTO  status; 
    
    private CommentRecyclerViewAdapter mCommentAdapter;

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

    @BindView(R.id.weibo_forward_number)
    public TextView forwardTv;

    @BindView(R.id.weibo_comments_number)
    public TextView commentTv;

    @BindView(R.id.weibo_goods_number)
    public TextView goodsTv;
    
    @BindView(R.id.weibo_comments)
    public RecyclerView weiBoRv;
    
    @BindView(R.id.relate_content)
    public RelativeLayout relateContent;
    
    @BindView(R.id.loading_rl)
    public RelativeLayout loadingRl;
    
    @BindView(R.id.weibo_content_rl)
    public RelativeLayout contentRl;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo);
        ButterKnife.bind(this);
        initView();
        initPresenter();
        mWeiBoId = getIntent().getStringExtra("id");
        getWeiBo();

    }

    private void getWeiBo() {
        weiBoPresenter.getWeiBoForId(LoginActivity.mAccessToken, mWeiBoId);
    }


    private void initView() {
        weiBoRv.setLayoutManager(new LinearLayoutManager(this));
        mCommentAdapter = new CommentRecyclerViewAdapter();
        weiBoRv.setAdapter(mCommentAdapter);
        weiBoRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 5;
            }
        });
    }

    private void initListener() {

    }

    private void initPresenter() {
        weiBoPresenter = PresenterManager.getInstance().getWeiBoPresenter();
        weiBoPresenter.registerViewCallback(this);
    }


    @Override
    public void onWeiBoLoaded(Comments comments) {
        if (comments != null){
            commentList = comments.getComments();
            status = comments.getStatus();
            mCommentAdapter.setData(commentList);
            if (loadingRl.getVisibility() == View.VISIBLE){
                setWeiBoData();
                setCommentsData();
                loadingRl.setVisibility(View.GONE);
                contentRl.setVisibility(View.VISIBLE);
            }
           
            
        }
    }

    private void setCommentsData() {
        
    }

    private void setWeiBoData() {
        
        String picUrl = status.getUser().getProfileImageUrl();
        if (picUrl != null && !picUrl.isEmpty()) {
            Glide.with(this).load(picUrl).into(this.avatarIV);
        } else {
            avatarIV.setImageResource(R.mipmap.ic_launcher_round);
        }
        sendNameTV.setText(status.getUser().getName());
        // 需要计算距离当前的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss +0800 yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(status.getCreatedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sendTimeTV.setText(CalculateTime.getShowTime(date));
        //来自有可能被隐藏
        if (status.getSource() != null &&
                !status.getSource().isEmpty()) {
            sendIphoneTV.setText("来自 " + ParseHref.parseHref(status.getSource()));
        } else {
            sendIphoneTV.setVisibility(View.GONE);
        }

        weiboContentTV.setText(status.getText());

        //如果1张图，用ImageView来显示
        //如果多张图，使用GridView来显示
        //如果没图，两个都不展示。
        if (status.getPicUrls().size() > 1){
            weiboContentPic.setVisibility(View.GONE);
            ArrayList<String> contentPicList = new ArrayList<>(status.getPicUrls().size());
            for (int i = 0; i < status.getPicUrls().size(); i++) {
                contentPicList.add(status.getPicUrls().get(i).getThumbnailPic());
            }
            if (!contentPicList.isEmpty()
                    && !contentPicList.get(0).isEmpty()) {
                MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter();

                myGridViewAdapter.setData(contentPicList, this);
//                myGridViewAdapter.setData(contentPicList, context);
                weiboPicGv.setAdapter(myGridViewAdapter);
                weiboPicGv.setVisibility(View.VISIBLE);

            }
        }else if(status.getPicUrls().size() == 1){
            weiboPicGv.setVisibility(View.GONE);
            String contentPicUrl = status.getBmiddlePic();
            if (contentPicUrl != null &&
                    !contentPicUrl.isEmpty()) {
                Object tag = weiboContentPic.getTag(R.id.weibo_one_pic);
                Glide.with(this)
                        .load(contentPicUrl)
                        .override(SizeUtils.dip2px(this,260f))
                        .into(this.weiboContentPic);
                weiboContentPic.setVisibility(View.VISIBLE);
            }
        }else{
            weiboPicGv.setVisibility(View.GONE);
            weiboContentPic.setVisibility(View.GONE);
            Glide.with(this).clear(weiboContentPic);

        }

        forwardTv.setText(status.getRepostsCount());
        commentTv.setText(status.getCommentsCount());
        goodsTv.setText(status.getAttitudesCount());
        relateContent.setVisibility(View.VISIBLE);
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
