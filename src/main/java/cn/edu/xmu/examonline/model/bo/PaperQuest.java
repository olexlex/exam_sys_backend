package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

@Data
public class PaperQuest {
    private Integer paperId;
    private Integer questId;
    private Integer questIndex;
    private String questAnswer;
}