package com.khh.web.utils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/5/22.
 */
public class MoneyConvert {

    private MoneyConvert(){}

    /**
     * 把金钱放大100倍，保存到分
     * @param str
     * @return
     */
    public static Long moneyStrToLong(String str){
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(str));
        BigDecimal multiply = bigDecimal.multiply(BigDecimal.valueOf(100L));
        return multiply.longValue();
    }


    /**
     * 把金钱放小100倍，保存到元，但精确到分
     */
    public static String moneyLongToStr(Long money){
        BigDecimal bigDecimal = BigDecimal.valueOf(money);
        BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(100L));
        return divide.toString();
    }

}
