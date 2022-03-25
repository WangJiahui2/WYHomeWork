package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AlchemyParamsDTO {
    @JSONField(name = "comment_guide_type")
    private Integer commentGuideType;
    @JSONField(name = "ug_red_envelope")
    private Boolean ugRedEnvelope;
}
