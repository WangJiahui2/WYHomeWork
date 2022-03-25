package com.wangyi.wyhomework.model.comments;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifiedDetailDTO {
    private Integer custom;
    private List<DataDTO> data;
}
