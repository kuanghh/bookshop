package com.khh.web.controller.terminal;

import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.PagerBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.constant_.Const;
import com.khh.web.domain.Person;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.GoodsService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/24.
 */
@Controller("terminalGoodsController")
@RequestMapping("/terminal/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    /**
     * 根据关键字或者类别的id,分页查询所有商品
     * @param pagerBean  key
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/findInPageByKey" ,method = RequestMethod.POST) /* get会乱码，post不会乱码*/
    public ResponseBean findInPageByKey(PagerBean<GoodsBean> pagerBean, GoodsBean key) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        if(key != null){
            pagerBean.setT(key);
        }
        //获取已认证店铺的商品
        if(!goodsService.findInPageByKey(pagerBean,true)){
            responseBean.setErrorResponse("获取失败");
            return responseBean;
        }

        responseBean.setData("page",pagerBean);
        responseBean.setSuccessResponse("获取成功");
        return responseBean;
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/findById" ,method = RequestMethod.POST)
    public ResponseBean findById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        if(id == null){
            responseBean.setErrorResponse("查询失败");
            return responseBean;
        }
        System.out.println();
        GoodsBean goodsBean = goodsService.findById(id);
        responseBean.setData("goods",goodsBean);
        responseBean.setSuccessResponse("查询成功");
        return responseBean;
    }
}
