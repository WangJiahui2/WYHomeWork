package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentBadgeDTO {
    @JSONField(name = "pic_url")
    private String picUrl;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "length")
    private Double length;
    @JSONField(name = "actionlog")
    private ActionlogDTO actionlog;
    @JSONField(name = "scheme")
    private String scheme;
}
