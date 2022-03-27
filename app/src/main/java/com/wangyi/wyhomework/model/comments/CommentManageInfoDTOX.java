package com.wangyi.wyhomework.model.comments;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentManageInfoDTOX {
    @JSONField(name = "comment_permission_type")
    private Integer commentPermissionType;
    @JSONField(name = "approval_comment_type")
    private Integer approvalCommentType;
    @JSONField(name = "comment_sort_type")
    private Integer commentSortType;
}
