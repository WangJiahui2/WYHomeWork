package com.wangyi.wyhomework.model.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReplyCommentDTO {
    private String createdAt;
    private Long id;
    private Long rootid;
    private String rootidstr;
    private Integer floorNumber;
    private String text;
    private Integer disableReply;
    private Integer restrictOperate;
    private UserDTOXXX user;
    private String mid;
    private String idstr;
}
