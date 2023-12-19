package cn.edu.xmu.examonline.model.vo;

import lombok.Data;

@Data
public class LoginVo {
    String token;
    Integer id;
    Integer type;
}
