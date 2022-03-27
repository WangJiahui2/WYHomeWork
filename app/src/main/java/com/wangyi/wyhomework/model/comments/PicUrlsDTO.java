package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PicUrlsDTO {
    @JSONField(name = "thumbnail_pic")
    private String thumbnailPic;
}
