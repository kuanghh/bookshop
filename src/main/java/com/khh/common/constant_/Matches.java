package com.khh.common.constant_;

/**
 * Created by 951087952@qq.com on 2017/4/18.
 * 匹配正则表达式
 */
public class Matches {
    /**
     * 密码正则表达式
     * 6位数字
     */
    final public static String PASSWORDPATTERN = "^[a-zA-Z0-9]{6,20}$";

    public static void main(String[] args) {
        String str = "123456";
        boolean matches = str.matches(PASSWORDPATTERN);
        System.out.println(matches);
    }
}
