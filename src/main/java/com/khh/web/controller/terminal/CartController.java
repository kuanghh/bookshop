package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.CartBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.common.constant_.ResponseBeanCode;
import com.khh.common.constant_.ResponseBeanType;
import com.khh.web.domain.Person;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.CartService;
import org.apache.commons.lang.StringUtils;
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
import java.util.List;

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
    @RequiresRoles(value = RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/addCart" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean addCart(@Valid CartBean cartBean, BindingResult result, HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        /**
         * 这里不许要验证是否登录，因为@RequiresRoles(RoleSign.SIMPLEUSER)，已经帮你判断是否有权限，若没有登录，也是没有权限
         */
//        if(person == null){
//            return noLogin();
//        }
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

    /**
     * 获取当前用户的购物车信息
     * @param session
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/getMyCart" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getMyCart(HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        /**
         * 这里不许要验证是否登录，因为@RequiresRoles(RoleSign.SIMPLEUSER)，已经帮你判断是否有权限，若没有登录，也是没有权限
         */
//        if(person == null){
//            return noLogin();
//        }
        List<CartBean> list = cartService.findAllCartByUserId(person.getId());

        responseBean.setData("list",list);
        responseBean.setSuccessResponse("查询成功");
        return responseBean;
    }

    /**
     * 删除记录信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/deleteById" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean deleteById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        if(id == null || !cartService.deleteById(id)){
            responseBean.setErrorResponse("删除失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("删除成功");
        return responseBean;
    }

    /**
     * 改变记录数
     * @return
     */
    @RequiresRoles(value = RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/changeNum" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean changeNum(@RequestParam("id") String id,@RequestParam("num") Integer num) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        if(id == null || num == null ){
            responseBean.setErrorResponse("修改失败");
            return responseBean;
        }

        String message = cartService.changeNum(id,num);
        if(message != null){
            responseBean.setErrorResponse(message);
            return responseBean;
        }
        responseBean.setSuccessResponse("修改成功");
        return responseBean;
    }


    /**
     * 计算价格
     * @return
     */
    @RequiresRoles(value = RoleSign.SIMPLEUSER)
    @RequestMapping(value = "/calTotalPrice" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean calTotalPrice(HttpSession session) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        String totalPrice = cartService.findForCaleTotalPrice(person.getId());
        if(StringUtils.isEmpty(totalPrice)){
            responseBean.setSuccessResponse("计算失败");
            return responseBean;
        }
        responseBean.setData("totalPrice",totalPrice);
        responseBean.setSuccessResponse("计算成功");
        return responseBean;
    }



}
