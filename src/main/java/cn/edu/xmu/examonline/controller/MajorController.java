package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.authorization.Auth;
import cn.edu.xmu.examonline.authorization.AuthAdmin;
import cn.edu.xmu.examonline.authorization.AuthInfo;
import cn.edu.xmu.examonline.model.vo.MajorVo;
import cn.edu.xmu.examonline.service.MajorService;
import cn.edu.xmu.examonline.util.Common;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="专业系统", tags="专业系统")
@RequestMapping(value = "/major", produces = "application/json;charset=UTF-8")
public class MajorController {

    @Autowired
    MajorService majorService;

    @ApiOperation(value = "用户使用专业ID获取单个专业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "专业id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("{id}")
    public Object getMajorById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) {
        var returnObj = majorService.getMajorById(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户使用专业名获取专业列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "专业名", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("/name/{name}")
    public Object getMajorByName(
            @PathVariable("name") String name,
            @Auth AuthInfo auth) {
        var returnObj = majorService.getMajorByName(name);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户获取所有专业列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("list")
    public Object getMajorList(
            @Auth AuthInfo auth) {
        var returnObj = majorService.getMajorList();
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员新增专业")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("")
    public Object insertMajor(
            @RequestBody MajorVo vo,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = majorService.insertMajor(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员根据专业ID修改专业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "专业id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("{id}")
    public Object updateMajorById(
            @PathVariable("id") Integer id,
            @RequestBody MajorVo vo,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = majorService.updateMajorById(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员根据专业ID删除专业")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "专业id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
    })
    @DeleteMapping("{id}")
    public Object deleteMajorById(
            @PathVariable("id") Integer id,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = majorService.deleteMajorById(id);
        return Common.getResponseObject(returnObj);
    }

}
