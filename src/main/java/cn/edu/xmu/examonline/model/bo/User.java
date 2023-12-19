package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer typeId;
}
