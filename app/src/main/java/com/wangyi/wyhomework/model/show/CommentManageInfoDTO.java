package com.wangyi.wyhomework.model.show;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentManageInfoDTO {
    private Integer commentManageButton;
    private Integer commentPermissionType;
    private Integer approvalCommentType;
    private Integer commentSortType;
}
