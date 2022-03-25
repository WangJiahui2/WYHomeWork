package com.wangyi.wyhomework.model.comments;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentsDTO {
    //评论时间
    private String createdAt;
    //id
    private String id;
    private String rootid;
    private String rootidstr;
    private Integer floorNumber;
    private String text;
    //回复
    private Integer disableReply;
    private Integer restrictOperate;
    private List<CommentBadgeDTO> commentBadge;
    //评论人信息
    private UserDTOX user;
    private String mid;
    private String idstr;
    private StatusDTOX status;
    private ReplyCommentDTO replyComment;
    private String readtimetype;
    private String replyOriginalText;
}
