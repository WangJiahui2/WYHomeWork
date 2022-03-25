package com.wangyi.wyhomework.model.weibolist;

import androidx.room.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeiBoList {

    @JSONField(name = "statuses")
    private List<StatusesDTO> statuses;
    @JSONField(name = "advertises")
    private List<?> advertises;
    @JSONField(name = "ad")
    private List<?> ad;
    @JSONField(name = "hasvisible")
    private Boolean hasvisible;
    @JSONField(name = "previous_cursor")
    private Integer previousCursor;
    @JSONField(name = "next_cursor")
    private String nextCursor;
    @JSONField(name = "previous_cursor_str")
    private String previousCursorStr;
    @JSONField(name = "next_cursor_str")
    private String nextCursorStr;
    @JSONField(name = "total_number")
    private Integer totalNumber;
    @JSONField(name = "interval")
    private Integer interval;
    @JSONField(name = "uve_blank")
    private Integer uveBlank;
    @JSONField(name = "since_id")
    private Long sinceId;
    @JSONField(name = "since_id_str")
    private String sinceIdStr;
    @JSONField(name = "max_id")
    private Long maxId;
    @JSONField(name = "max_id_str")
    private String maxIdStr;
    @JSONField(name = "has_unread")
    private Integer hasUnread;
}
