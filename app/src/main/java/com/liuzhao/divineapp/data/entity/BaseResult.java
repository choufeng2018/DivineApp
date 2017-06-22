package com.liuzhao.divineapp.data.entity;

import com.liuzhao.divineapp.data.entity.main.Joke;

import java.io.Serializable;
import java.util.List;

/**
 * 接口通用字段父类，外层解析需继承
 *
 * @author PengGuoHua
 * @Date 2015-05-20
 */
public class BaseResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 685145794678572999L;
    /**
     * 错误码 -1 通常提示性错误 -1000 用户没有登陆 -1001 用户不存在 -1002 用户账号或者密码错误 -1003 用户账号错误
     * -1004 用户账号被锁定 -1005 用户没有被授权 -2000 客户端参数错误 -3000 服务器错误
     */
    public int error_code;
    /**
     * 接口响应信息
     */
    private String reason;

    public T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
