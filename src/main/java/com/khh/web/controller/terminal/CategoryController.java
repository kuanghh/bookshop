package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.CategoryBean;
import com.khh.common.bean.ResponseBean;
import com.khh.web.security.PermissionSign;
import com.khh.web.service.interface_.CategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Controller("terminalCategoryController")
@RequestMapping("/terminal/category")
public class CategoryController extends BaseController{

    @Resource
    private CategoryService categoryService;

    /**
     * 获取全部分类
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getAll" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getAll() throws Exception{
        ResponseBean responseBean = new ResponseBean();
        System.out.println("get all Category");
        List<CategoryBean> list = categoryService.findAll();
        if(list == null || list.isEmpty()){
            responseBean.setErrorResponse("获取失败");
            return  responseBean;
        }
        responseBean.setSuccessResponse("获取成功");
        responseBean.setData("list",list);
        return responseBean;
    }
}
