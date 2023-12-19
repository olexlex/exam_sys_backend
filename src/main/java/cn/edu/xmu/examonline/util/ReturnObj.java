package cn.edu.xmu.examonline.util;

import lombok.Data;


/**
 * 用于包装返回数据和状态码的类型
 * @param <T> 数据类型
 */
@Data
public class ReturnObj<T> {

    T data = null;
    ReturnStatus status = ReturnStatus.OK;

    public ReturnObj(ReturnStatus status) {
        this.status = status;
    }
    public ReturnObj(T data) {
        this.data = data;
    }

    public ReturnObj(ReturnStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public T getData() { return data; }

    public boolean ok() { return getStatus().ok(); }

    public ReturnStatus getStatus() { return status; }

}
