package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.authorization.Auth;
import cn.edu.xmu.examonline.authorization.AuthAdmin;
import cn.edu.xmu.examonline.authorization.AuthInfo;
import cn.edu.xmu.examonline.authorization.exception.AuthException;
import cn.edu.xmu.examonline.model.vo.UserProfileVo;
import cn.edu.xmu.examonline.model.vo.UserVo;
import cn.edu.xmu.examonline.service.UserService;
import cn.edu.xmu.examonline.util.Common;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="用户系统", tags="用户系统")
@RequestMapping(value = "user/", produces = "application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * User对象处理
     * @return HTTP对象
     */
    @ApiOperation(value = "管理员/用户自己使用用户ID获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("{id}")
    public Object getUserById(
            @PathVariable("id") int id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var ret = userService.getUserById(id);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员/用户自己使用用户名获取用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("name/{name}")
    public Object getUserByName(
            @PathVariable("name") String name,
            @Auth AuthInfo auth) throws AuthException {
        var ret = userService.getUserByName(name);
        auth.checkOperateRes(ret.getData().getId());
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员获取所有用户列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("list")
    public Object getUserList(
            @AuthAdmin AuthInfo authAdmin){
        var ret = userService.getUserList();
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员获取某类型ID的用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "类型id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("list/type/{id}")
    public Object getUserList(
            @PathVariable("id") int id,
            @AuthAdmin AuthInfo authAdmin){
        var ret = userService.getUserListByType(id);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "游客/用户新增普通用户，同时创建用户Profile")
    @PostMapping("user")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 600, message = "用户名已存在")
    })
    public Object createCommonUser(
            @RequestBody UserVo user){
        var ret = userService.createCommonUser(user);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员新增管理员用户，同时创建用户Profile")
    @PostMapping("admin")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 600, message = "用户名已存在")
    })
    public Object createAdminUser(
            @RequestBody UserVo user,
            @AuthAdmin AuthInfo authAdmin){
        var ret = userService.createAdminUser(user);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员/用户自身使用用户ID修改单个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("{id}")
    public Object updateUserById(
            @PathVariable("id") Integer id,
            @RequestBody UserVo user,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(user.getId());
        var ret = userService.updateUserById(user);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员/用户自身使用ID删除单个用户，同时删除用户Profile")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @DeleteMapping("{id}")
    public Object deleteUserById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var ret = userService.deleteUserById(id);
        return Common.getResponseObject(ret);
    }



    /**
     * UserProfile对象处理
     * @return HTTP对象
     */
    @ApiOperation(value = "管理员/用户自身使用ID获取单个用户的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("profile/{id}")
    public Object getUserProfileById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var ret = userService.getUserProfileById(id);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "管理员获取所有用户详细信息列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("profile/list")
    public Object getUserProfileList(
            @AuthAdmin AuthInfo authAdmin){
        var ret = userService.getUserProfileList();
        return Common.getResponseObject(ret);
    }

    /*
    @ApiOperation(value = "新增用户详细信息")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("userprofile/")
    public Object insertUserProfile(@RequestBody UserProfileVo userProfile){
        var ret = userService.insertUserProfile(userProfile);
        return Common.getResponseObject(ret);
    }
    */

    @ApiOperation(value = "管理员/用户自身使用ID更新单个用户的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("profile/{id}")
    public Object updateUserProfileById(
            @PathVariable("id") Integer id,
            @RequestBody UserProfileVo userProfile,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var ret = userService.updateUserProfileById(userProfile);
        return Common.getResponseObject(ret);
    }

    /*
    @ApiOperation(value = "使用ID删除单个用户的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @DeleteMapping("userprofile/{id}")
    public Object deleteUserProfileById(@PathVariable("id") Integer id){
        var ret = userService.deleteUserProfileById(id);
        return Common.getResponseObject(ret);
    }
    */

    /**
     * UserType对象处理
     * @return HTTP对象
     */

    /*
    @ApiOperation(value = "使用ID获取单个用户类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("usertype/{id}")
    public Object getUserTypeById(@PathVariable("id") Integer id){
        var ret = userService.getUserTypeById(id);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "获取全部用户类型列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("usertype/list")
    public Object getUserTypeList(){
        var ret = userService.getUserTypeList();
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "新增用户类型")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("usertype")
    public Object insertUserType(@RequestBody UserTypeVo userType){
        var ret = userService.insertUserType(userType);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "使用ID更新单个用户类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("usertype/{id}")
    public Object updateUserTypeById(@PathVariable("id") Integer id, @RequestBody UserTypeVo userType){
        var ret = userService.updateUserTypeById(userType);
        return Common.getResponseObject(ret);
    }

    @ApiOperation(value = "使用ID删除单个用户类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @DeleteMapping("usertype/{id}")
    public Object deleteUserTypeById(@PathVariable("id") Integer id){
        var ret = userService.deleteUserTypeById(id);
        return Common.getResponseObject(ret);
    }
    */
}
