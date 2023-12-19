package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

@Data
public class UserProfile {
    private Integer userId;
    private String name;
    private Integer age;
    private String address;
    private String email;
    private String phone;

    public Integer getId(){
        return userId;
    }
}
