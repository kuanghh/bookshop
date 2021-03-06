package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.ShopRegisterBean;
import com.khh.web.service.interface_.PersonService;
import com.khh.web.service.interface_.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/5/18.
 * 前台商家控制器
 */
@Controller("fontShopController")
@RequestMapping("/shop")
public class ShopController extends BaseController{

    @Resource
    private ShopService shopService;

    @Resource
    private PersonService personService;

    /**
     * 登录UI
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginUI" ,method = RequestMethod.GET)
    public String goToLogin() throws Exception{

        return "redirect:/admin/login.html";
    }

    /**
     * 注册
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean register(@Valid ShopRegisterBean shopRegisterBean, BindingResult result) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        //信息验证
        if(result.hasErrors()){
            responseBean.setErrorResponse(result.getFieldError().getDefaultMessage());
            return responseBean;
        }

        String message = personService.findForCheckRegisterRepeatInfo(shopRegisterBean.getAccount(), shopRegisterBean.getEmail(), shopRegisterBean.getPhone());
        if(message != null){
            responseBean.setErrorResponse(message);
            return responseBean;
        }

        int i = shopService.insert(shopRegisterBean);
        if(i == 0){
            responseBean.setSuccessResponse("注册成功,请等待管理员进行认证");
            return responseBean;
        }

        responseBean.setErrorResponse("注册失败");
        return responseBean;
    }
}
