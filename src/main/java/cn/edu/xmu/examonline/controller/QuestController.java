package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.authorization.Auth;
import cn.edu.xmu.examonline.authorization.AuthAdmin;
import cn.edu.xmu.examonline.authorization.AuthInfo;
import cn.edu.xmu.examonline.model.vo.QuestVo;
import cn.edu.xmu.examonline.service.QuestService;
import cn.edu.xmu.examonline.util.Common;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="题目系统", tags="题目系统")
@RequestMapping(value = "/quest", produces = "application/json;charset=UTF-8")
public class QuestController {

    @Autowired
    QuestService questService;

    @ApiOperation(value = "用户使用题目ID获取单个题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "题目id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("{id}")
    public Object getQuestById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) {
        var returnObj = questService.getQuestById(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员获取所有题目列表")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("list")
    public Object getQuestList(
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.getQuestList();
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员获取某专业ID的题目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "专业ID", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("major/{id}")
    public Object getQuestListByMajorId(
            @PathVariable("id") Integer id,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.getQuestByMajorId(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员获取某专业ID的某题型的题目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "专业ID", required = true, paramType = "path"),
            @ApiImplicitParam(name = "type", value = "类型ID", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("major/{id}/type/{type}")
    public Object getQuestListByMajorIdAndType(
            @PathVariable("id") Integer id,
            @PathVariable("id") Integer type,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.getQuestByMajorIdAndType(id, type);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户获取某试卷ID的题目列表（按题号顺序排列，试卷未完成时答案为null）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "试卷ID", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("paper/{id}")
    public Object getQuestListByPaperId(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) {
        var returnObj = questService.getQuestByPaperIdOrderByIndex(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员新增题目")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PostMapping("")
    public Object insertQuest(
            @RequestBody QuestVo vo,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.insertQuest(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员根据题目ID修改题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "题目id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @PutMapping("{id}")
    public Object updateQuestById(
            @PathVariable("id") Integer id,
            @RequestBody QuestVo vo,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.updateQuestById(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "管理员根据题目ID删除题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "题目id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 800, message = "题目被现存试卷包含")
    })
    @DeleteMapping("{id}")
    public Object deleteQuestById(
            @PathVariable("id") Integer id,
            @AuthAdmin AuthInfo authAdmin) {
        var returnObj = questService.deleteQuestById(id);
        return Common.getResponseObject(returnObj);
    }

}
