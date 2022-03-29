package com.wangyi.wyhomework.ui.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wangyi.wyhomework.R;
import com.wangyi.wyhomework.model.comments.CommentsDTO;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentRecyclerViewAdapter.InnerHolder> {


    private List<CommentsDTO> mData = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weibo_comment, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        //绑定数据
        CommentsDTO comment = mData.get(position);
        holder.setData(comment);

    }

    @Override
    public int getItemCount() {
            return mData.size();
            
    }

    public void setData(List<CommentsDTO> commentList) {
        this.mData.clear();
        this.mData.addAll(commentList);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.avatar)
        public ImageView avatar;

        @BindView(R.id.send_name)
        public TextView name;

        @BindView(R.id.comment_content)
        public TextView content;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(CommentsDTO comment) {
            Context context = itemView.getContext();
            if (comment.getUser() != null &&
                    comment.getUser().getProfileImageUrl() != null) {
                String avatarUrl = comment.getUser().getProfileImageUrl();
                Glide.with(context).load(avatarUrl).into(avatar);
            } else {
                avatar.setImageResource(R.mipmap.ic_launcher_round);
            }
            
            if (comment.getUser() != null && 
                comment.getUser().getName() != null){
                name.setText(comment.getUser().getName());
            } 
            
            if (comment.getText() != null && 
                !comment.getText().isEmpty()){
                content.setText(comment.getText());
            }
        }
    }
}
