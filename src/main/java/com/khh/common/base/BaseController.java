package com.khh.common.base;

import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.ResponseBeanCode;
import com.khh.common.constant_.ResponseBeanType;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 951087952@qq.com on 2017/4/18.
 * BaseController  用来处理异常
 */
public class BaseController {

    /**
     * 使用@ExceptionHandler注解，继承此类的Controller发生异常时会自动执行该方法
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseBody
    public ResponseBean exception(Exception e) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setErrorResponse("系统繁忙");
        e.printStackTrace();
        //对异常进行判断做相应的处理
        //没有权限的异常
        if(e instanceof AuthorizationException){
            System.out.println("go to index.jsp");
            responseBean.setErrorResponse("你没有权限");
            return responseBean;
        }
        return responseBean;
    }

    protected ResponseBean noLogin(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(ResponseBeanCode.NO_LOGIN);
        responseBean.setType(ResponseBeanType.ERROR);
        responseBean.setMessage("请你先登录");
        return responseBean;

    }
}
