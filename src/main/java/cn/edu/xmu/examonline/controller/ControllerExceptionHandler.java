package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import cn.edu.xmu.examonline.authorization.exception.AuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { AuthException.class })
    public Object authExceptionHandler(AuthException e) {
        return Common.getResponseObject(new ReturnObj<Object>(e.getStatus()));
    }

    @ExceptionHandler(value = { Exception.class })
    public Object exceptionHandler(Exception e) {
        e.printStackTrace();
        return Common.getResponseObject(new ReturnObj<Object>(ReturnStatus.INTERNAL_SERVER_ERR));
    }

}