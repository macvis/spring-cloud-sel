package com.tee.springcloudsel.order.enums;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
public enum ResultEnum {
    /**
     * 参数校验未通过
     */
    PARAM_VALIDATE_FAILED(501, "参数校验未通过"),
    /**
     * 系统错误
     */
    INTERNAL_ERROR(502, "系统错误"),

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
