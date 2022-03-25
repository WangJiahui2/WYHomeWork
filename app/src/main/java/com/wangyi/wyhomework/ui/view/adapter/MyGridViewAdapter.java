package com.wangyi.wyhomework.ui.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wangyi.wyhomework.R;

import java.util.ArrayList;

public class MyGridViewAdapter extends BaseAdapter {
    private ArrayList<String> imageUrlList;
    private Context context;
    
    public void setData(ArrayList<String> picUrlList, Context context){
        this.imageUrlList = picUrlList;
        this.context = context;
    }
    @Override
    public int getCount() {
        return imageUrlList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageUrlList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            
            holder = new ViewHolder();
            
            convertView = View.inflate(context, R.layout.item_weibopic_gridview,null);
            // 第一次加载创建View，其余复用 View
            
            holder.imageView = convertView.findViewById(R.id.weibo_pic_item);
            
            convertView.setTag(holder);

        } else {
            // 从标签中获取数据
            holder = (ViewHolder) convertView.getTag();
        }

        // 根据key值设置不同数据内容
        Glide.with(context).load(imageUrlList.get(position)).into(holder.imageView);

        return convertView;
        
    }


    class ViewHolder {
        
        ImageView imageView;

    }
}
