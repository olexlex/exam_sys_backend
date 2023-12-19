package cn.edu.xmu.examonline.controller;

import cn.edu.xmu.examonline.authorization.Auth;
import cn.edu.xmu.examonline.authorization.AuthAdmin;
import cn.edu.xmu.examonline.authorization.AuthInfo;
import cn.edu.xmu.examonline.authorization.exception.AuthException;
import cn.edu.xmu.examonline.model.vo.PaperUserAnswerVo;
import cn.edu.xmu.examonline.model.vo.PaperVo;
import cn.edu.xmu.examonline.model.vo.ShortAnswerVo;
import cn.edu.xmu.examonline.service.PaperService;
import cn.edu.xmu.examonline.util.Common;
import cn.edu.xmu.examonline.util.ReturnObj;
import cn.edu.xmu.examonline.util.ReturnStatus;
import cn.edu.xmu.examonline.util.TextSimilarity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(value="试卷系统", tags="试卷系统")
@RequestMapping(value = "/paper", produces = "application/json;charset=UTF-8")
public class PaperController {

    @Autowired
    PaperService paperService;

    @ApiOperation(value = "用户使用试卷ID获取属于自己的单个试卷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "试卷id", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("{id}")
    public Object getPaperById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(paperService.getPaperUserById(id).getData());
        var returnObj = paperService.getPaperById(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户获取自己的试卷列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("user/{id}")
    public Object getPaperListByUserId(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var returnObj = paperService.getPaperListByUserId(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户获取自己的某个名字的试卷列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path"),
            @ApiImplicitParam(name = "name", value = "试卷名", required = true, paramType = "path"),
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("user/{id}/name/{name}")
    public Object getPaperListByUserIdAndName(
            @PathVariable("id") Integer id,
            @PathVariable("name") String name,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(id);
        var returnObj = paperService.getPaperListByUserIdAndName(id, name);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户创建自己的试卷")
    @ApiImplicitParams({
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 902, message = "试卷专业题目不足"),
            @ApiResponse(code = 903, message = "试卷所选专业不合法")
    })
    @PostMapping("create")
    public Object insertPaper(
            @RequestBody PaperVo vo,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(vo.getUserId());
        var returnObj = paperService.createPaper(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户使用试卷ID删除自己的试卷")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "试卷id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @DeleteMapping("{id}")
    public Object deletePaperById(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(paperService.getPaperUserById(id).getData());
        var returnObj = paperService.deletePaperById(id);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户使用试卷ID提交自己的试卷作答")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "试卷id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误"),
            @ApiResponse(code = 900, message = "更新题目答案失败"),
            @ApiResponse(code = 901, message = "试卷已经提交")
    })
    @PostMapping("{id}/submit")
    public Object submitPaper(
            @RequestBody PaperUserAnswerVo vo,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(paperService.getPaperUserById(vo.getId()).getData());
        var returnObj = paperService.submitPaper(vo);
        return Common.getResponseObject(returnObj);
    }

    @ApiOperation(value = "用户使用试卷ID获取自己的试卷作答")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "试卷id", required = true, paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("{id}/answer")
    public Object getPaperUserAnswer(
            @PathVariable("id") Integer id,
            @Auth AuthInfo auth) throws AuthException {
        auth.checkOperateRes(paperService.getPaperUserById(id).getData());
        var returnObj = paperService.getPaperUserAnswerById(id);
        return Common.getResponseObject(returnObj);
    }

    /**
     * 简答题自动评分
     *
     * return
     */
    @ApiOperation(value = "简答题自动评分测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paperId", value = "试卷id",required = true,paramType = "path"),
            @ApiImplicitParam(name = "questId", value = "题目id",required = true,paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功"),
            @ApiResponse(code = 404, message = "资源ID不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    @GetMapping("shortAnswerJudge/{paperId}/question/{questId}")
    public Object getShortAnswerPoint(
            @PathVariable("paperId") Integer paperId,
            @PathVariable("questId") Integer questId,
            @Auth AuthInfo auth) throws AuthException, IOException {

        String answerUser = paperService.getUserAnswerByIds(paperId, questId);
        String answerStandard = paperService.getStandardAnswerById(questId);

        var r = TextSimilarity.analysis(answerUser, answerStandard);
        return Common.getResponseObject(new ReturnObj<>(r));
    }

}

