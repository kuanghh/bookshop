package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/24.
 * 首页控制器
 */
@Controller
@RequestMapping("/terminal/index")
public class IndexController extends BaseController{

    /**
     * 跳转到首页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String IndexUI() throws Exception{
        return "forward:/terminal/html/index.html";
    }


}
