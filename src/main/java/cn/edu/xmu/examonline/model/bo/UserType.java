package cn.edu.xmu.examonline.model.bo;

import lombok.Data;

@Data
public class UserType {
    private Integer id;
    private String name;

    public Integer getId(){
        return id;
    }
}
