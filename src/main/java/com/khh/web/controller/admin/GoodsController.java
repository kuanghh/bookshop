package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.GoodsBean;
import com.khh.common.bean.ResponseBean;
import com.khh.common.bean.UserRegisterBean;
import com.khh.web.service.interface_.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean add(@Valid GoodsBean goodsBean, BindingResult result, MultipartFile[] files) throws Exception{
        ResponseBean responseBean = new ResponseBean();



        responseBean.setSuccessResponse("注册成功");
        return responseBean;
    }


}



