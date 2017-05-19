package com.khh.web.controller.admin;

import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.ShopRegisterBean;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.ShopService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 * 前台商家控制器
 */
@Controller("backShopController")
@RequestMapping("/back/shop")
public class ShopController {

    @Resource
    private ShopService shopService;



    /**
     * 根据关键字，分页获取用户
     * @param pagerBean map
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/findInPageAndKey" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean findInPageAndKey(PagerBean pagerBean, @RequestParam Map<String,String> map) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        //如果提交数据有关键字则....
        if(map != null && !map.isEmpty()){
            if(map.containsKey("pageNo")){
                map.remove("pageNo");
            }
            pagerBean.setKeyMap(map);
        }
        if(!shopService.findInPageAndKey(pagerBean)){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }
        System.out.println();
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

        if(id != null && shopService.deleteById(id)){
            responseBean.setSuccessResponse("删除成功");
            return responseBean;
        }

        responseBean.setErrorResponse("删除失败");
        return responseBean;
    }



    /**
     * 根据id认证商家
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/authen" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean authen(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        if(id != null && shopService.updateForAuthen(id)){
            responseBean.setSuccessResponse("认证成功");
            return responseBean;
        }

        responseBean.setErrorResponse("认证失败");
        return responseBean;
    }

}