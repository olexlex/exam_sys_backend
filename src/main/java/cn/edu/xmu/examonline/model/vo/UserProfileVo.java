package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class UserProfileVo {
    private Integer userId;
    private String name;
    private Integer age;
    private String address;
    private String email;
    private String phone;
    private Integer typeId;
}
