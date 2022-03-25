package com.wangyi.wyhomework.model.show;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StatusTotalCounterDTO {
    private Integer totalCnt;
    private Integer repostCnt;
    private Integer commentCnt;
    private Integer likeCnt;
    private Integer commentLikeCnt;
}
