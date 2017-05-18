package com.khh.web.controller.terminal;

import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.ShopRegisterBean;
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
 * 商家控制器
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

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
        System.out.println("商家进行注册");
        //信息验证
        if(result.hasErrors()){
            responseBean.setErrorResponse(result.getFieldError().getDefaultMessage());
            return responseBean;
        }
        int i = shopService.insert(shopRegisterBean);
        if(i == 0){
            responseBean.setErrorResponse("注册失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("注册成功,请等待管理员进行认证");
        return responseBean;
    }
}
