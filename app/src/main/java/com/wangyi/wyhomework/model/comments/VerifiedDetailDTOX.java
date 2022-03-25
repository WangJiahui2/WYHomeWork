package com.wangyi.wyhomework.model.comments;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VerifiedDetailDTOX {
    private Integer custom;
    private List<DataDTOX> data;
}
