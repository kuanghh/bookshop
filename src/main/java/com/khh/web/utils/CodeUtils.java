package com.khh.web.utils;

import java.util.UUID;

/**
 * Created by 951087952@qq.com on 2017/4/20.
 */
public class CodeUtils {
    private CodeUtils(){

    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 生成订单号
     */
    public static String getOrderSerial(){
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s.substring(0,15);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(CodeUtils.getUUID());
        }
    }

}
