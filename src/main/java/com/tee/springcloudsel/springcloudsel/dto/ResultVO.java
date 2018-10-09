package com.tee.springcloudsel.springcloudsel.dto;

import lombok.Data;

/**
 * @author youchao.wen
 * @date 2018/10/8.
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T result;

    public ResultVO(){
        this.success();
    }

    public ResultVO(T result){
        this.success(result);
    }

    public void success(){
        this.setCode(200);
        this.setMsg("success");
    }

    public void success(T result){
        this.setCode(200);
        this.setMsg("success");
        this.setResult(result);
    }
}
