package com.khh.web.controller.terminal;

import com.khh.common.base.BaseController;
import com.khh.common.bean.PagerBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * Created by Administrator on 2017/5/24.
 */
@Controller
@RequestMapping("/terminal/img")
public class ImgController extends BaseController{

    /**
     * 根据关键字或者类别的id,分页查询所有商品
     * @param   response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getImg" ,method = RequestMethod.GET)
    public void findInPageByKey(HttpServletResponse response, String address) throws Exception{
        try {
            if(address == null){
                return ;
            }
            FileInputStream fis = new FileInputStream(address.substring(1,address.length()-1));//去掉双引号
            OutputStream os = response.getOutputStream();
            int count = -1;
            byte[] buffer = new byte[1024 * 8];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
            fis.close();
            response.setContentType("image/"); // 设置返回的文件类型
            os.write(buffer); // 输出数据
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
