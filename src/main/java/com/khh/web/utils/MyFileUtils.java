package com.khh.web.utils;

import com.khh.common.constant_.Const;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class MyFileUtils {

    /**
     * 保存所有图片并返回图片名称集合
     * @param files
     * @return
     */
    public static List<String> saveFile(MultipartFile[] files){
        List<String> imgList = new ArrayList<>();
        if(files.length == 0) throw new RuntimeException();
        for (int i = 0; i < files.length; i++) {
            // TODO 图片格式验证
            String fileName = System.currentTimeMillis() + "_" + files[i].getOriginalFilename();
            //保存文件
            try {
                String picPath = Const.IMGSAVEPATH + "/" + fileName;
                files[i].transferTo(new File(picPath));
                //把路径保存imgList
                imgList.add(picPath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return imgList;
    }
}
