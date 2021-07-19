package com.xushifei.uims.common.exception;


import com.xushifei.uims.common.enums.ApiCodeEnum;

/**
 * @author xushifei
 * @date 2020/12/5 11:47
 * @description
 */
public class BusinessException extends RuntimeException {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误码描述
     */
    private String msg;

    public BusinessException() {
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ApiCodeEnum apiCodeEnum) {
        super(apiCodeEnum.getMsg());
        this.code = apiCodeEnum.getCode();
        this.msg = apiCodeEnum.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}