package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.OrdersBean;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
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
@Controller("adminOrdres")
@RequestMapping("/back/orders")
public class OrdersController extends BaseController{

    @Resource
    private OrdersService ordersService;



    /**
     * 获取当前商家的所有的订单信息
     */
    @RequiresRoles(RoleSign.SHOP)
    @RequestMapping(value = "/getMyOrders" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean getMyOrders(PagerBean<OrdersBean> pagerBean,OrdersBean ordersBean,HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);

        if(ordersBean == null){
            ordersBean = new OrdersBean();
        }
        ordersBean.setShopId(person.getId());
        pagerBean.setT(ordersBean);
        boolean success = ordersService.findInPageWithKey(pagerBean);
        if(!success){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }
        responseBean.setData("page",pagerBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

    /**
     * 商家发货
     */
    @RequiresRoles(RoleSign.SHOP)
    @RequestMapping(value = "/doOrders" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean doOrders(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        if(id == null || !ordersService.updateOrdersState(id)){
            responseBean.setErrorResponse("发货失败");
            return responseBean;
        }

        responseBean.setSuccessResponse("发货成功");
        return responseBean;
    }
}
