package cn.edu.xmu.examonline.authorization;

import cn.edu.xmu.examonline.authorization.exception.AuthException;
import cn.edu.xmu.examonline.util.ReturnStatus;
import lombok.Data;

@Data
public class AuthInfo {

    int userId;
    int userType;
    String userName;
    String token;

    public void checkOperateRes(int resUserId) throws AuthException {
        if(userId != resUserId && userType == 2)
            throw new AuthException(ReturnStatus.FORBIDDEN);
    }

}
