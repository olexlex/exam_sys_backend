package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class MajorVo {
    private Integer id;
    private String name;
    private Integer singleSelectionNum;
    private Integer multipleSelectionNum;
    private Integer judgementNum;
    private Integer shortAnswerNum;
}

