package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DataDTO {
    @JSONField(name = "key")
    private Integer key;
    @JSONField(name = "sub_key")
    private Integer subKey;
    @JSONField(name = "weight")
    private Integer weight;
    @JSONField(name = "desc")
    private String desc;
}
