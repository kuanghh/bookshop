package com.khh.test;

import com.alibaba.fastjson.JSONObject;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.Goods;
import com.khh.web.domain.Person;
import com.khh.web.domain.User;
import com.khh.web.utils.BeanUtilEx;
import org.apache.commons.beanutils.BeanUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 */
public class TestSomeThing {

    public static void main(String[] args) throws Exception {
//        test1();
//        test2();
//        test3();
            test4();
    }

//    public static void  test1() throws Exception{
//        UserRegisterBean u = new UserRegisterBean();
//        u.setPhone("18927766631");
//        u.setAccount("kuanghh");
//        u.setBirthday(new Date());
//        u.setEmail("951087952@qq.com");
//        u.setName("haohua");
//        u.setPassword("123456");
//
//
//        Person person = (Person) BeanUtilEx.copyProperties2(new Person(), u);
//        User user = (User) BeanUtilEx.copyProperties2(new User(), u);
//
//        System.out.println(person.toString());
//        System.out.println(user.toString());
//
//        System.out.println(person.getId());
//        System.out.println(user.getId());
//
//        System.out.println(person.getAccount());
//        System.out.println(user.getAccount());
//    }

//    public static void test2() throws Exception{
//        String str = "10.03";
//        Float f1 = Float.parseFloat(str);
//        long l = f1.longValue();
//        System.out.println(l);
//    }
//
//    public static void test3() throws Exception{
//        List<String> list = new ArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        System.out.println(JSONObject.toJSONString(list));
//    }

    public static void test4() throws  Exception{
//        FileInputStream fis = new FileInputStream("E:/img/1495469074775_logo.png");
//        OutputStream os = new FileOutputStream("E:/1.png");
//        int count = -1;
//        byte[] buffer = new byte[1024 * 8];
//        while ((count = fis.read(buffer)) != -1) {
//            os.write(buffer, 0, count);
//            os.flush();
//        }
//        fis.close();
//        os.close();

        String decode = URLDecoder.decode("%E4%B8%8A%E6%B5%B7", "utf-8");
        System.out.println(decode);
    }
}
