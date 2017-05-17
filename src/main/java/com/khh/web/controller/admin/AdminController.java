package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 * 管理员控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @RequestMapping(value = "/loginUI" ,method = RequestMethod.GET)
    public String goToLogin() throws Exception{

        return "redirect:/admin/login.html";
    }

}
