package com.khh.web.controller.admin;

import com.khh.common.base.BaseController;
import com.khh.common.bean.CategoryBean;
import com.khh.common.bean.ResponseBean;
import com.khh.web.security.RoleSign;
import com.khh.web.service.interface_.CategoryService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController{

    @Resource
    private CategoryService categoryService;


    /**
     * 添加新类别
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean insert(CategoryBean categoryBean) throws Exception{
        ResponseBean responseBean = new ResponseBean();

         //判断当前类别是否存在
        if(categoryService.findByName(categoryBean.getName()) > 0){
            responseBean.setErrorResponse("当前分类已经存在");
            return responseBean;
        }
        categoryService.insert(categoryBean);
        responseBean.setSuccessResponse("添加分类成功");
        return responseBean;
    }

    /**
     * 获取全部分类
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/getAll" ,method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean getAll() throws Exception{
        ResponseBean responseBean = new ResponseBean();

        List<CategoryBean> list = categoryService.findAll();
        if(list == null || list.isEmpty()){
            responseBean.setErrorResponse("获取失败");
            return  responseBean;
        }
        responseBean.setSuccessResponse("获取成功");
        responseBean.setData("list",list);
        return responseBean;
    }

    /**
     * 删除分类
     * @param
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = RoleSign.SYSTEMADMIN)
    @RequestMapping(value = "/deleteById" ,method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean deleteById(String id) throws Exception{
        ResponseBean responseBean = new ResponseBean();

        if(id == null || !categoryService.deleteById(id)){
            responseBean.setErrorResponse("删除失败");
            return responseBean;
        }
        responseBean.setSuccessResponse("删除成功");
        return responseBean;
    }

}
