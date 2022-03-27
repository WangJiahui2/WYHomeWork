package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VideoTotalCounterDTOX {
    @JSONField(name = "play_cnt")
    private Integer playCnt;
}
