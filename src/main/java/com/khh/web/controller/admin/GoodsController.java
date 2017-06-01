package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.web.domain.Goods;
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
        //信息验证
        if(result.hasErrors() || person == null){
            return "redircet:/error.jsp";
        }

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
    @RequestMapping(value = "/findInPageByKey" ,method = RequestMethod.POST)
    public ResponseBean findInPageByKey(HttpSession session, PagerBean<GoodsBean> pagerBean,GoodsBean key) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        //获取当前商家的id
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        key.setShopId(person.getId());
        if(key != null){
            pagerBean.setT(key);
        }
        //获取不必认证过店铺的商品
        if(!goodsService.findInPageByKey(pagerBean,false)){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }

        responseBean.setData("page",pagerBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

    /**
     * 根据id,删除商品
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @ResponseBody
    @RequestMapping(value = "/deleteById" ,method = RequestMethod.POST)
    public ResponseBean deleteById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        if(id == null ||  !goodsService.deleteById(id)){
            responseBean.setErrorResponse("删除失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("删除成功");
        return responseBean;
    }


    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @ResponseBody
    @RequestMapping(value = "/findById" ,method = RequestMethod.POST)
    public ResponseBean findById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        if(id == null){
            responseBean.setErrorResponse("查询失败");
            return responseBean;
        }
        GoodsBean goodsBean = goodsService.findById(id);
        responseBean.setData("goods",goodsBean);
        responseBean.setSuccessResponse("查询成功");
        return responseBean;
    }

    /**
     * 改变商品状态，下架还是上架
     * @param id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @ResponseBody
    @RequestMapping(value = "/changeState" ,method = RequestMethod.POST)
    public ResponseBean changeState(String id,int state) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        // TODO 这里做得不好，如果当状态很多的时候，这里要修改，可以尝试把所有状态改成枚举类型
        if(state != Goods.STATE_VALID && state != Goods.STATE_NOVALID){
            responseBean.setErrorResponse("修改失败");
            return responseBean;
        }

        if(id == null  || !goodsService.updateState(id,state)){
            responseBean.setErrorResponse("修改失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("修改成功");
        return responseBean;
    }

    /**
     * 修改商品
     * @param goodsBean result
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SHOP)
    @RequestMapping(value = "/edit" ,method = RequestMethod.POST)
    public String edit(@Valid GoodsBean goodsBean, BindingResult result, @RequestParam("files") MultipartFile[] files,HttpSession session) throws Exception{
        Person person = (Person) session.getAttribute(Const.LOGIN_USER);
        if(result.hasErrors()){
            return "redircet:/error.jsp";
        }


        goodsBean.setShopId(person.getId());

        boolean success = goodsService.update(goodsBean,files);
        System.out.println(success);
        return success ? "redirect:/admin/jsps/listBook.html" : "redircet:/error.jsp";
    }

}



