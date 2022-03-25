package com.wangyi.wyhomework.model.weibolist;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class NumberDisplayStrategyDTO {
    @JSONField(name = "apply_scenario_flag")
    private Integer applyScenarioFlag;
    @JSONField(name = "display_text_min_number")
    private Integer displayTextMinNumber;
    @JSONField(name = "display_text")
    private String displayText;
}
