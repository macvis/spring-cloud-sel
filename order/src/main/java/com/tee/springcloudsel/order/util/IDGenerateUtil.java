package com.tee.springcloudsel.order.util;

import java.util.Random;

/**
 * 主键生成util类
 *
 * @author youchao.wen
 * @date 2018/10/27.
 */
public class IDGenerateUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String generateId(){
        Random ra = new Random();
        Integer num = ra.nextInt(90000) + 100000;

        return System.currentTimeMillis() + num + "";
    }
}
