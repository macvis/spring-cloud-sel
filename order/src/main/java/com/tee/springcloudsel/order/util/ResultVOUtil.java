package com.tee.springcloudsel.order.util;

import com.tee.springcloudsel.order.enums.ResultEnum;
import com.tee.springcloudsel.springcloudsel.dto.ResultVO;

/**
 * @author youchao.wen
 * @date 2018/10/27.
 */
public class ResultVOUtil {
    public static ResultVO success(Object obj){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        resultVO.setResult(obj);

        return resultVO;
    }

}
