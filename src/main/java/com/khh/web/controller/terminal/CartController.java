package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.CartBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.common.constant_.ResponseBeanCode;
import com.khh.common.constant_.ResponseBeanType;
import com.khh.web.domain.Person;
import com.khh.web.service.interface_.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/5/25.
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{

    @Resource
    private CartService cartService;


    /**
     * 添加购物车
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addCart" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean addCart(@Valid CartBean cartBean, BindingResult result, HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        if(person == null){
            responseBean.setCode(ResponseBeanCode.NO_LOGIN);
            responseBean.setType(ResponseBeanType.ERROR);
            responseBean.setMessage("请你先登录");
            return responseBean;
        }
        cartBean.setUserId(person.getId());
        //信息验证
        if(result.hasErrors()){
            responseBean.setErrorResponse(result.getFieldError().getDefaultMessage());
            return responseBean;
        }

        if(!cartService.insert(cartBean)){
            responseBean.setErrorResponse("添加失败");
            return responseBean;
        }

        responseBean.setSuccessResponse("添加成功");
        return responseBean;
    }

}
