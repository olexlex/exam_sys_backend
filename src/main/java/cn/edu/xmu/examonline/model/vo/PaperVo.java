package cn.edu.xmu.examonline.model.vo;

import cn.edu.xmu.examonline.model.vo.PaperQuestVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PaperVo {

    private Integer id;
    private Integer userId;
    private Integer major1Id;
    private Integer major2Id;
    private Integer major3Id;
    private String major1Name;
    private String major2Name;
    private String major3Name;
    private Integer questNum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;
    private Boolean isEnded;
    private String name;

}