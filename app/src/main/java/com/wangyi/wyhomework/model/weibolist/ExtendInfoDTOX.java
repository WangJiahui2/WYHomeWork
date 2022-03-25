package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExtendInfoDTOX {
    @JSONField(name = "shopwindow_card")
    private ShopwindowCardDTOX shopwindowCard;
}
