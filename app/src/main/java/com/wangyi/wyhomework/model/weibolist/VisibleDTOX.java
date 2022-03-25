package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VisibleDTOX {
    @JSONField(name = "type")
    private Integer type;
    @JSONField(name = "list_id")
    private Integer listId;
}
