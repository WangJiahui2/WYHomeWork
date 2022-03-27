package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AlchemyParamsDTO {
    @JSONField(name = "ug_red_envelope")
    private Boolean ugRedEnvelope;
}
