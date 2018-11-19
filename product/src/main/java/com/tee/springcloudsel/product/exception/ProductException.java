package com.tee.springcloudsel.product.exception;

import com.tee.springcloudsel.product.enums.ResultEnum;
import lombok.Data;

/**
 * @author youchao.wen
 * @date 2018/11/17.
 */
@Data
public class ProductException extends Exception {
    private int code;
    private String message;

    public ProductException(String message, int code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

    public ProductException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ProductException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }
}
