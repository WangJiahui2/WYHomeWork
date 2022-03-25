package com.wangyi.wyhomework.model.comments;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Comment {

    private List<CommentsDTO> comments;
    private List<?> marks;
    private Boolean hasvisible;
    private Integer previousCursor;
    private Long nextCursor;
    private String previousCursorStr;
    private String nextCursorStr;
    private Integer totalNumber;
    private Integer sinceId;
    private Long maxId;
    private String sinceIdStr;
    private String maxIdStr;
    private StatusDTO status;
}
