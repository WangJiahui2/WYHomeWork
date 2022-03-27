package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 微博详情页的实现   comments/show接口
 *  * https://api.weibo.com/2/comments/show.json?access_token=
 *  2.00Y9T87IJMhzkB66f58113630AHVce&id=4751602571542856
 */
@NoArgsConstructor
@Data
public class Comments {


    @JSONField(name = "comments")
    private List<CommentsDTO> comments;
    @JSONField(name = "marks")
    private List<?> marks;
    @JSONField(name = "hasvisible")
    private Boolean hasvisible;
    @JSONField(name = "previous_cursor")
    private Integer previousCursor;
    @JSONField(name = "next_cursor")
    private Long nextCursor;
    @JSONField(name = "previous_cursor_str")
    private String previousCursorStr;
    @JSONField(name = "next_cursor_str")
    private String nextCursorStr;
    @JSONField(name = "total_number")
    private Integer totalNumber;
    @JSONField(name = "since_id")
    private Integer sinceId;
    @JSONField(name = "max_id")
    private Long maxId;
    @JSONField(name = "since_id_str")
    private String sinceIdStr;
    @JSONField(name = "max_id_str")
    private String maxIdStr;
    @JSONField(name = "status")
    private StatusDTO status;
}
