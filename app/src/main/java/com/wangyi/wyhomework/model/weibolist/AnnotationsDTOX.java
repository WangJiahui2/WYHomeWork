package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnnotationsDTOX {
    @JSONField(name = "photo_sub_type")
    private String photoSubType;
    @JSONField(name = "client_mblogid")
    private String clientMblogid;
    @JSONField(name = "mapi_request")
    private Boolean mapiRequest;
}
