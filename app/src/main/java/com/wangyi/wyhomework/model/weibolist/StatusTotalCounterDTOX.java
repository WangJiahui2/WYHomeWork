package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusTotalCounterDTOX {
    @JSONField(name = "total_cnt")
    private String totalCnt;
    @JSONField(name = "repost_cnt")
    private Integer repostCnt;
    @JSONField(name = "comment_cnt")
    private Integer commentCnt;
    @JSONField(name = "like_cnt")
    private Integer likeCnt;
    @JSONField(name = "comment_like_cnt")
    private Integer commentLikeCnt;
}
