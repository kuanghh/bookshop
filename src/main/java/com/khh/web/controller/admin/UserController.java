package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.UserRegisterBean;
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
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 后台普通用户控制器
 */
@Controller(value = "backUserController")
@RequestMapping("/back/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private PersonService personService;

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
     * @param pagerBean map
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/findInPageAndKey" ,method = RequestMethod.GET)
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

    /**
     * 根据id删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/deleteById" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean deleteById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        if(id != null && userService.deleteById(id)){
            responseBean.setSuccessResponse("删除成功");
            return responseBean;
        }
        responseBean.setErrorResponse("删除失败");
        return responseBean;

    }
}
