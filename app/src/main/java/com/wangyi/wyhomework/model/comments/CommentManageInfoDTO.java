package com.wangyi.wyhomework.model.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentManageInfoDTO {
    private Integer commentPermissionType;
    private Integer approvalCommentType;
    private Integer commentSortType;
}
