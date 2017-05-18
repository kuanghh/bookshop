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
 * 普通用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private PersonService personService;


    /**
     * 登录UI
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
     * @param
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
     * 获取全部用户
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/getAll" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getAll() throws Exception{
        ResponseBean responseBean = new ResponseBean();

        List<UserRegisterBean> list = userService.findAllBean();
        if(list == null){
            responseBean.setErrorResponse("获取失败");
        }
        responseBean.setData("list",list);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

    /**
     * 根据关键字，分页获取用户
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/findInPageAndKey" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean findInPageAndKey(PagerBean pagerBean,@RequestParam Map<String,String> map) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        //如果提交数据有关键字则....
        if(map != null && !map.isEmpty()){
            if(map.containsKey("pageNo")){
                map.remove("pageNo");
            }
            pagerBean.setKeyMap(map);
        }
        if(!userService.findInPageAndKey(pagerBean)){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }

        responseBean.setData("page",pagerBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

}
