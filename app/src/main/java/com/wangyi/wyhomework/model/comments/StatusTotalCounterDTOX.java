package com.wangyi.wyhomework.model.comments;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusTotalCounterDTOX {
    private Integer totalCnt;
    private Integer repostCnt;
    private Integer commentCnt;
    private Integer likeCnt;
    private Integer commentLikeCnt;
}
