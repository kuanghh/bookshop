package com.khh.web.controller;

import com.khh.common.base.BaseController;
import com.khh.common.bean.LoginBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.common.constant_.PersonLogin;
import com.khh.web.domain.Person;
import com.khh.web.domain.Role;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.PersonService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by 951087952@qq.com on 2017/5/16.
 * 登录控制器
 */
@Controller
@RequestMapping("/index")
public class LoginController extends BaseController{

    @Resource
    private PersonService personService;

    /***
     * 登录
     * @param loginBean
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(@Valid LoginBean loginBean, BindingResult result, HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Subject subject = SecurityUtils.getSubject();
        //不能同时登录两个账号
        if(subject.isAuthenticated()){
            responseBean.setErrorResponse("已经登录了");
            return responseBean;
        }
        //信息验证
        if(result.hasErrors()){
            responseBean.setErrorResponse(result.getFieldError().getDefaultMessage());
            return responseBean;
        }
        //身份验证
        try{
            if(!loginBean.isEffective()){
                responseBean.setErrorResponse("请填写登录信息");
                return responseBean;
            }
            //获取登录信息(帐号、邮箱、手机号码，具体看提交了什么)并进行验证
            if(loginBean.getValidInfoToLogin() != null){
                subject.login(new UsernamePasswordToken(loginBean.getValidInfoToLogin(),loginBean.getPassword()));
            }
        }catch (AuthenticationException e){
            e.printStackTrace();
            responseBean.setErrorResponse("登录失败");
            return responseBean;
        }
        //获取认证时所查询出来的人物信息
        Person p = PersonLogin.get();
        //验证成功在Session中保存当前用户信息
        session.setAttribute(Const.LOGIN_USER,p);
        /**
         * Context.remove()的作用:
         * 当tomcat启动的时候，会创建一个线程池，而每次处理请求的线程从线程池取出，如果调用ThreadLocal.set()方法，将一个
         * 对象放入Thread中的成员变量threadLocals中，那么这个对象是永远不会被回收的，所以为了避免浪费java堆内存，则需要
         * 调用Context.remove();
         */
        PersonLogin.remove();
        responseBean.setSuccessResponse("登录成功");
        return responseBean;
    }

    /**
     * 注销
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/exit" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean exit(HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            responseBean.setErrorResponse("请登录");
            return responseBean;
        }
        try{
            //退出  同等于session.removeAttribute(Const.LOGIN_USER);
            subject.logout();
        }catch (AuthenticationException e){
            e.printStackTrace();
            responseBean.setErrorResponse("注销失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("注销成功");
        return responseBean;
    }

    /**
     * 获取当前角色
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRole" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getRole(HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Subject subject = SecurityUtils.getSubject();

        if(subject.hasRole(RoleSign.SYSTEMADMIN)){
            responseBean.setData("role",RoleSign.SYSTEMADMIN);
        }else if(subject.hasRole(RoleSign.SHOP)){
            responseBean.setData("role",RoleSign.SHOP);
        }else if(subject.hasRole(RoleSign.SIMPLEUSER)){
            responseBean.setData("role",RoleSign.SIMPLEUSER);
        }
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

}
