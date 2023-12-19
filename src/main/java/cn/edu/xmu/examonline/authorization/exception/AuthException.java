package cn.edu.xmu.examonline.authorization.exception;

import cn.edu.xmu.examonline.util.ReturnStatus;

public class AuthException extends Exception {

    private ReturnStatus status;


    public AuthException(ReturnStatus status) {
        this.status = status;
    }

    public ReturnStatus getStatus() {
        return status;
    }

    public void setStatus(ReturnStatus status) {
        this.status = status;
    }
}
