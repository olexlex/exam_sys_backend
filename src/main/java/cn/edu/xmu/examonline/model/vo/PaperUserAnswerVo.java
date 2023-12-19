package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PaperUserAnswerVo {

    private Integer id;

    private List<PaperQuestVo> answers;

}
