package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExtendInfoDTO {
    @JSONField(name = "ad")
    private AdDTO ad;
    @JSONField(name = "shopwindow_card")
    private ShopwindowCardDTO shopwindowCard;
}
