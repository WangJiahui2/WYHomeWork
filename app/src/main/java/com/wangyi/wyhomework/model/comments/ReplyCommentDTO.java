package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReplyCommentDTO {
    @JSONField(name = "created_at")
    private String createdAt;
    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "rootid")
    private Long rootid;
    @JSONField(name = "rootidstr")
    private String rootidstr;
    @JSONField(name = "floor_number")
    private Integer floorNumber;
    @JSONField(name = "text")
    private String text;
    @JSONField(name = "disable_reply")
    private Integer disableReply;
    @JSONField(name = "restrictOperate")
    private Integer restrictOperate;
    @JSONField(name = "comment_badge")
    private List<CommentBadgeDTO> commentBadge;
    @JSONField(name = "user")
    private UserDTOXXX user;
    @JSONField(name = "mid")
    private String mid;
    @JSONField(name = "idstr")
    private String idstr;
}
