package cn.edu.xmu.examonline.util;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;


/**
 * 返回状态码的枚举类型
 * 包含约定的错误码、错误信息、错误码对应的HTTP状态码
 */
public enum ReturnStatus {

    // 成功 (code=0 HTTP=200)
    OK(0,"成功"),

    // 客户端错误 (code=HTTP=40x)
    FIELD_INVALID(400,"请求不合法", HttpStatus.BAD_REQUEST),
    TOKEN_INVALID(401,"身份认证无效", HttpStatus.UNAUTHORIZED),
    FORBIDDEN(403,"没有操作该资源的权限", HttpStatus.FORBIDDEN),
    RESOURCE_ID_NOTEXIST(404,"操作的资源id不存在", HttpStatus.NOT_FOUND),

    // 服务器错误 (code=HTTP=50x)
    INTERNAL_SERVER_ERR(500,"服务器内部错误", HttpStatus.INTERNAL_SERVER_ERROR),

    // User&Auth模块错误  (code=60x HTTP=200)
    USER_NAME_DUPLICATED(600, "用户名已存在"),
    AUTH_WRONG_NAME_OR_PASSWORD(601, "用户名或密码错误"),

    // Major模块错误 (code=70x HTTP=200)

    // Quest模块错误 (code=80x HTTP=200)
    QUEST_IN_PAPER(800, "题目被现存试卷包含"),

    // Paper模块错误 (code=90x HTTP=200)
    PAPER_QUEST_ANSWER_INVALID(900, "更新题目答案失败"),
    PAPER_ENDED(901, "试卷已经提交"),
    PAPER_MAJOR_NOT_ENOUGH_QUEST(902, "试卷专业题目不足"),
    PAPER_MAJOR_INVALID(903, "试卷所选专业不合法");

    private final int no;
    private final String message;

    private final HttpStatus httpStatus;

    private static Map<Integer, ReturnStatus> returnStatusMap;

    static {
        returnStatusMap = new HashMap<>();
        for (var status : ReturnStatus.values())
            returnStatusMap.put(status.no, status);
    }

    ReturnStatus(int no, String msg, HttpStatus httpStatus) {
        this.no = no;
        this.message = msg;
        this.httpStatus = httpStatus;
    }

    ReturnStatus(int no, String msg) {
        this.no = no;
        this.message = msg;
        this.httpStatus = HttpStatus.OK;
    }

    public String getMessage() {
        return message;
    }
    public int getNo() {
        return no;
    }

    public boolean ok() { return this.no == OK.no; }

    public HttpStatus getHttpStatus() { return httpStatus; }

    public static ReturnStatus getByCode(int code) {
        return returnStatusMap.get(code);
    }

}
