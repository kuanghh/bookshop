package com.khh.common.constant_;

import com.khh.web.domain.Person;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 * 帮助验证解耦
 */
public class PersonLogin {
    private PersonLogin(){}

    private static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();

    public static Person get(){
        return threadLocal.get();
    }

    public static void set(Person person){
        threadLocal.set(person);
    }

    public static void remove(){
        threadLocal.remove();
    }
}
