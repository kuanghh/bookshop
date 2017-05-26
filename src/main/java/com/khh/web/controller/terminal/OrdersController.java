package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.OrdersBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.web.domain.Orders;
import com.khh.web.domain.Person;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.OrdersService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/26.
 * 订单控制器
 */
@Controller("terminalOrdres")
@RequestMapping("/terminal/orders")
public class OrdersController extends BaseController{

    @Resource
    private OrdersService ordersService;


    /**
     * 创建订单
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/createOrders" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean createOrders(HttpSession session,@RequestParam("address") String address) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);


        String message = ordersService.insertOrders(person.getId(),address);

        if(!"success".equals(message)){
            responseBean.setErrorResponse(message);
            return responseBean;
        }
        responseBean.setSuccessResponse(message);
        return responseBean;
    }
}
