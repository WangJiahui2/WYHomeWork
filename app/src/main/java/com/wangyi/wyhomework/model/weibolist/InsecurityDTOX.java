package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InsecurityDTOX {
    @JSONField(name = "sexual_content")
    private Boolean sexualContent;
}
