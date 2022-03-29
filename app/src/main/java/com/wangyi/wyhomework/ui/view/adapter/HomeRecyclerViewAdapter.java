package com.wangyi.wyhomework.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.common.CalculateTime;
import com.wangyi.wyhomework.common.MyGridView;
import com.wangyi.wyhomework.model.weibolist.StatusesDTO;
import com.wangyi.wyhomework.model.weibolist.WeiBoList;
import com.wangyi.wyhomework.utils.ParseHref;
import com.wangyi.wyhomework.utils.SizeUtils;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //原创微博和非原创微博
    private static final int ORIGINAL_WB = 0;
    private static final int FORWARD_WB = 1;
    private List<StatusesDTO> mData = new ArrayList<>();
    private OnListItemClickListener mItemClickListener = null;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder holder;
        if (viewType == ORIGINAL_WB) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_original_weibo_content, parent, false);
            holder = new OriginalWBInnerHolder(itemView);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forward_weibo_content, parent, false);
            holder = new ForWardWBInnerHolder(itemView);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StatusesDTO statusesDTO = mData.get(position);
        if (holder instanceof OriginalWBInnerHolder) {
            OriginalWBInnerHolder originalWBInnerHolder =(OriginalWBInnerHolder) holder;
            try {
                originalWBInnerHolder.setData(statusesDTO,position);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            originalWBInnerHolder.weiboContentPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });

            originalWBInnerHolder.weiboContentTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });
            originalWBInnerHolder.avatarIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });
            originalWBInnerHolder.relateContentRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });
        } else {
            ForWardWBInnerHolder forWardWBInnerHolder = (ForWardWBInnerHolder) holder;
            try {
                forWardWBInnerHolder.setData(statusesDTO);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            forWardWBInnerHolder.avatarIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });

            forWardWBInnerHolder.weiboContentTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });

            forWardWBInnerHolder.relateContentRl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null){
                        mItemClickListener.onOriginalItemClick(view, statusesDTO);
                    }
                }
            });
        }
    }


    /**
     * 进行不同列表格式的判断，以生成不同样式的viewHolder
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getRetweetedStatus() == null
                || mData.get(position).getRetweetedStatus().getText().isEmpty()) {
            return ORIGINAL_WB;
        } else {
            return FORWARD_WB;
        }
        // return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    
    public void setData(WeiBoList weiBoList) {
        this.mData.clear();
        this.mData.addAll(weiBoList.getStatuses());
        notifyDataSetChanged();
    }

    public class OriginalWBInnerHolder extends RecyclerView.ViewHolder {

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

        @BindView(R.id.relate_content)
        public RelativeLayout relateContentRl;

        public OriginalWBInnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void setData(StatusesDTO statusesDTO,int position) throws ParseException {
            //利用Glide加载图片需要context
            Context context = itemView.getContext();
            String picUrl = statusesDTO.getUser().getProfileImageUrl();
            if (picUrl != null && !picUrl.isEmpty()) {
                Glide.with(context).load(picUrl).into(this.avatarIV);
            } else {
                avatarIV.setImageResource(R.mipmap.ic_launcher_round);
            }
            sendNameTV.setText(statusesDTO.getUser().getName());
            // 需要计算距离当前的时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss +0800 yyyy", Locale.ENGLISH);
            Date date = dateFormat.parse(statusesDTO.getCreatedAt());
            sendTimeTV.setText(CalculateTime.getShowTime(date));
            //来自有可能被隐藏
            if (statusesDTO.getSource() != null &&
                    !statusesDTO.getSource().isEmpty()) {
                sendIphoneTV.setText("来自 " + ParseHref.parseHref(statusesDTO.getSource()));
            } else {
                sendIphoneTV.setVisibility(View.GONE);
            }

            weiboContentTV.setText(statusesDTO.getText());

            //如果1张图，用ImageView来显示
            //如果多张图，使用GridView来显示
            //如果没图，两个都不展示。
            if (statusesDTO.getPicUrls().size() > 1){
                weiboContentPic.setVisibility(View.GONE);
                ArrayList<String> contentPicList = new ArrayList<>(statusesDTO.getPicUrls().size());
                for (int i = 0; i < statusesDTO.getPicUrls().size(); i++) {
                    contentPicList.add(statusesDTO.getPicUrls().get(i).getThumbnailPic());
                }
                if (!contentPicList.isEmpty()
                        && !contentPicList.get(0).isEmpty()) {
                    MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter();
                    
                    myGridViewAdapter.setData(contentPicList, context);
//                myGridViewAdapter.setData(contentPicList, context);
                    weiboPicGv.setAdapter(myGridViewAdapter);
                    weiboPicGv.setVisibility(View.VISIBLE);

                }
            }else if(statusesDTO.getPicUrls().size() == 1){
                weiboPicGv.setVisibility(View.GONE);
                String contentPicUrl = statusesDTO.getBmiddlePic();
                if (contentPicUrl != null &&
                        !contentPicUrl.isEmpty()) {
                    Object tag = weiboContentPic.getTag(R.id.weibo_one_pic);
                    if (tag != null && (int) tag != position ){
                        Glide.with(context).clear(weiboContentPic);
                    }
                    Glide.with(context)
                            .load(contentPicUrl)
                            .override(SizeUtils.dip2px(context,260f))
                            .into(this.weiboContentPic);
                    weiboContentPic.setVisibility(View.VISIBLE);
                    weiboContentPic.setTag(R.id.weibo_one_pic,position);
                } 
            }else{
                weiboPicGv.setVisibility(View.GONE);
                weiboContentPic.setVisibility(View.GONE);
                Glide.with(context).clear(weiboContentPic);
                weiboContentPic.setTag(R.id.weibo_one_pic,position);
            }
            
            forwardTv.setText(statusesDTO.getRepostsCount());
            commentTv.setText(statusesDTO.getCommentsCount());
            goodsTv.setText(statusesDTO.getAttitudesCount());

        }
    }

    /**
     * 转发微博
     */
    public class ForWardWBInnerHolder extends RecyclerView.ViewHolder {


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

        @BindView(R.id.forward_name)
        public TextView forwardNameTV;


//        @BindView(R.id.forward_content_tv)
//        public TextView forwardContentTV;

        @BindView(R.id.forward_one_pic)
        public ImageView forwardPicIV;

        @BindView(R.id.forward_weibo_gridview)
        public MyGridView forwardPicGv;
        
        @BindView(R.id.forward_number)
        public TextView forwardTv;

        @BindView(R.id.comments_number)
        public TextView commentTv;

        @BindView(R.id.goods_number)
        public TextView goodsTv;
        
        @BindView(R.id.relate_content)
        public RelativeLayout relateContentRl;

        public ForWardWBInnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(StatusesDTO statusesDTO) throws ParseException {
            //利用Glide加载图片需要context
            Context context = itemView.getContext();
            String picUrl = statusesDTO.getUser().getProfileImageUrl();
            if (picUrl != null && !picUrl.isEmpty()) {
                Glide.with(context).load(picUrl).into(this.avatarIV);
            } else {
                avatarIV.setImageResource(R.mipmap.ic_launcher_round);
            }
            sendNameTV.setText(statusesDTO.getUser().getName());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss +0800 yyyy", Locale.ENGLISH);
            Date date = dateFormat.parse(statusesDTO.getCreatedAt());
            sendTimeTV.setText(CalculateTime.getShowTime(date));
            
            if (statusesDTO.getSource() != null &&
                    !statusesDTO.getSource().isEmpty()) {
                sendIphoneTV.setText("来自 " + ParseHref.parseHref(statusesDTO.getSource()));
            } else {
                sendIphoneTV.setVisibility(View.GONE);
            }
            weiboContentTV.setText(statusesDTO.getText());

            //接下来为转发的原微博内容
//            forwardNameTV.setText("@" + statusesDTO.getRetweetedStatus().getUser().getName() + ":");
            forwardNameTV.setText(MessageFormat.format(context.getString(R.string.forward_name_content), statusesDTO.getRetweetedStatus().getUser().getName(),statusesDTO.getRetweetedStatus().getText()));
//            forwardContentTV.setText(statusesDTO.getRetweetedStatus().getText());
            
            if (statusesDTO.getPicUrls().size() > 1){
                ArrayList<String> contentPicList = new ArrayList<>(statusesDTO.getPicUrls().size());
                for (int i = 0; i < statusesDTO.getPicUrls().size(); i++) {
                    contentPicList.add(statusesDTO.getPicUrls().get(i).getThumbnailPic());
                }
                if (!contentPicList.isEmpty()
                        && !contentPicList.get(0).isEmpty()) {
                    MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter();
                    myGridViewAdapter.setData(contentPicList, context);
                    forwardPicGv.setAdapter(myGridViewAdapter);
                    forwardPicGv.setVisibility(View.VISIBLE);

                }
            }else{
                String contentPicUrl = statusesDTO.getBmiddlePic();
                if (contentPicUrl != null &&
                        !contentPicUrl.isEmpty()) {
                    Glide.with(context).load(contentPicUrl).into(this.forwardPicIV);
                    forwardPicIV.setVisibility(View.VISIBLE);
                }
            }

            forwardTv.setText(statusesDTO.getRepostsCount());
            commentTv.setText(statusesDTO.getCommentsCount());
            goodsTv.setText(statusesDTO.getAttitudesCount());
        }
    }

    public void setOnListItemClickListener(OnListItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public interface OnListItemClickListener {
        void onOriginalItemClick(View view, StatusesDTO item);

        void onForwardItemClick(View view, StatusesDTO item);
    }
}

