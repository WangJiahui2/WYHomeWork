package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifiedDetailDTO {
    @JSONField(name = "custom")
    private Integer custom;
    @JSONField(name = "data")
    private List<DataDTO> data;
}
