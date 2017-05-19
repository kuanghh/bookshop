package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.domain.User;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.PersonService;
import com.khh.web.service.interface_.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 前台普通用户控制器
 */
@Controller(value = "fontUserController")
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private PersonService personService;


    /**
     * 跳转登录UI
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginUI" ,method = RequestMethod.GET)
    public String goToLogin() throws Exception{

        return "redirect:/terminal/login.html";
    }

    /**
     * 注册UI
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/registerUI" ,method = RequestMethod.GET)
    public String register() throws Exception{
        return "redirect:/terminal/register.html";
    }


    /**
     * 注册
     * @param registerBean result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean register(@Valid UserRegisterBean registerBean, BindingResult result) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        //信息验证
        if(result.hasErrors()){
            responseBean.setErrorResponse(result.getFieldError().getDefaultMessage());
            return responseBean;
        }
        int i = userService.insert(registerBean);
        if(i == 0){
            responseBean.setErrorResponse("注册失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("注册成功");
        return responseBean;
    }


}
