package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class PaperQuestVo {
    private Integer paperId;
    private Integer questId;
    private Integer questIndex;
    private String questAnswer;
}