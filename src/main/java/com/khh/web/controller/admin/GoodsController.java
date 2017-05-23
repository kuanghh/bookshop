package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.web.domain.Person;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.GoodsService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/20.
 * 后台商品控制器
 */
@Controller(value = "backGoodsController")
@RequestMapping("/back/Goods")
public class GoodsController extends BaseController{

    @Resource
    private GoodsService goodsService;


    /**
     * 添加商品
     * @param goodsBean result
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String add(@Valid GoodsBean goodsBean, BindingResult result, @RequestParam("files") MultipartFile[] files, HttpSession session) throws Exception{

        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        goodsBean.setShopId(person.getId());

        boolean success = goodsService.insert(goodsBean,files);

        return success ? "redirect:/admin/jsps/listBook.html" : "redircet:/error.jsp";
    }

    /**
     * 根据关键字,商家的id,分页查询所有商品
     * @param session
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @ResponseBody
    @RequestMapping(value = "/findInPageByKey" ,method = RequestMethod.GET)
    public ResponseBean findInPageByKey(HttpSession session, PagerBean<GoodsBean> pagerBean,GoodsBean key) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        //获取当前商家的id
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        key.setShopId(person.getId());
        if(key != null){
            pagerBean.setT(key);
        }
        if(!goodsService.findInPageByKey(pagerBean)){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }

        responseBean.setData("page",pagerBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

}



