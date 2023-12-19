package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.authorization.Auth;
import cn.edu.xmu.examonline.authorization.AuthInfo;
import cn.edu.xmu.examonline.service.AuthService;
import cn.edu.xmu.examonline.util.Common;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(value="身份认证系统", tags="身份认证系统")
@RequestMapping(value = "/auth", produces = "application/json;charset=UTF-8")
public class AuthController {

    @Autowired
    AuthService authService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 601, message = "用户名或密码错误")
    })
    @PostMapping("login")
    public Object login(@RequestParam("name") String name, @RequestParam("password") String password) {
        var ret = authService.login(name, password);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "用户登出")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 601, message = "用户名或密码错误")
    })
    @PostMapping("logout")
    public Object logout(@Auth AuthInfo authInfo) {
        var ret = authService.logout(authInfo.getToken());
        return Common.getResponseObject(ret);
    }

}
