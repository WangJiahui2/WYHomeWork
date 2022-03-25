package com.wangyi.wyhomework.ui.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wangyi.wyhomework.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteWeiBoActivity extends AppCompatActivity {

    
    @BindView(R.id.cancel)
    public TextView cancleTv;
    
    @BindView(R.id.send_weibo)
    public TextView sendTv;
    
    @BindView(R.id.writer_weibo)
    public TextView weiboTv;
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_weibo);
        ButterKnife.bind(this);
        
    }


    private void initListener() {
        cancleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStop();
            }
        });
        
        sendTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        
        
    }
}
