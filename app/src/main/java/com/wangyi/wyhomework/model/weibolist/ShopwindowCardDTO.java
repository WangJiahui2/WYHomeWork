package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ShopwindowCardDTO {
    @JSONField(name = "adId")
    private String adId;
    @JSONField(name = "keywords")
    private String keywords;
    @JSONField(name = "level")
    private String level;
    @JSONField(name = "short_url")
    private String shortUrl;
}
