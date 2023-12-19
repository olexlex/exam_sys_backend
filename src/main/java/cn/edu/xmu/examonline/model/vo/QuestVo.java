package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class QuestVo {

    private Integer id;

    private Integer majorId;

    private String majorName;

    private Integer typeId;

    private String description;

    private String answer;

    private Integer selectionNum;

    private String selectionA;

    private String selectionB;

    private String selectionC;

    private String selectionD;

    private String selectionE;

    private String selectionF;

}