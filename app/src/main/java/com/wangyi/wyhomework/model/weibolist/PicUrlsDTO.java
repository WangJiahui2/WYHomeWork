package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PicUrlsDTO {
    @JSONField(name = "thumbnail_pic")
    private String thumbnailPic;
}
