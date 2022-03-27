package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ActionlogDTOX {
    @JSONField(name = "act_code")
    private String actCode;
    @JSONField(name = "ext")
    private String ext;
}
