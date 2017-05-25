package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.UserBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.common.constant_.Const;
import com.khh.web.domain.Person;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.PersonService;
import com.khh.web.service.interface_.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


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

    /**
     * 获取当前用户的信息
     * @param session
     * @return
     * @throws Exception
     */
    @RequiresRoles(RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/myInfo" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean myInfo(HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        /**
         * 这里不许要验证是否登录，因为@RequiresRoles(RoleSign.SIMPLEUSER)，已经帮你判断是否有权限，若没有登录，也是没有权限
         */
//        if(person == null){
//            return noLogin();
//        }
        UserBean userBean = userService.findById(person.getId());
        if(userBean == null){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }
        responseBean.setData("user",userBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

    /**
     * 修改当前用户信息
     * @param session
     * @return
     * @throws Exception
     */
    @RequiresRoles(RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/editUser" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean editUser(UserBean userBean,HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        /**
         * 这里不许要验证是否登录，因为@RequiresRoles(RoleSign.SIMPLEUSER)，已经帮你判断是否有权限，若没有登录，也是没有权限
         */
//        if(person == null){
//            return noLogin();
//        }
        userBean.setId(person.getId());
        if(!userService.update(userBean)){
            responseBean.setErrorResponse("修改失败");
            return responseBean;
        }

        responseBean.setSuccessResponse("修改成功");
        return responseBean;
    }

    /**
     * 验证交易密码
     * @param session
     * @return
     * @throws Exception
     */
    @RequiresRoles(RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/checkPwd" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean checkPwd(String password,HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        int count = personService.findByIdAndPassword(person.getId(),password);
        if(count == 1){
            responseBean.setSuccessResponse("验证成功");
            return responseBean;
        }

        responseBean.setErrorResponse("验证出错");
        return responseBean;
    }

}
