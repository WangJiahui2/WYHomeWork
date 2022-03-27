package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifiedDetailDTOX {
    @JSONField(name = "custom")
    private Integer custom;
    @JSONField(name = "data")
    private List<DataDTOX> data;
}
