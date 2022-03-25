package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VideoTotalCounterDTO {
    @JSONField(name = "play_cnt")
    private Integer playCnt;
}
