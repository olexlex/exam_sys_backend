package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

import java.util.Date;

@Data
public class Paper {

    private Integer id;
    private Integer userId;
    private Integer major1Id;
    private Integer major2Id;
    private Integer major3Id;
    private Integer questNum;
    private Date startTime;
    private Date endTime;
    private Boolean isEnded;
    private String name;

}