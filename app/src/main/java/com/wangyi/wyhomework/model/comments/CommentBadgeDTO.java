package com.wangyi.wyhomework.model.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CommentBadgeDTO {
    private String picUrl;
    private String name;
    private Double length;
    private ActionlogDTO actionlog;
    private String scheme;
}
