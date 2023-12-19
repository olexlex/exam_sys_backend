package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class UserVo {
    private Integer id;
    private String name;
    private String password;
    private Integer typeId;
}
