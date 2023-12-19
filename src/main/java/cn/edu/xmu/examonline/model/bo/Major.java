package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

@Data
public class Major {
    private Integer id;
    private String name;
    private Integer singleSelectionNum;
    private Integer multipleSelectionNum;
    private Integer judgementNum;
    private Integer shortAnswerNum;
}
