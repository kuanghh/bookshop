package com.khh.web.service.impl;

import com.khh.web.dao.ShopMapper;
import com.khh.web.service.interface_.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 951087952@qq.com on 2017/5/17.
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ShopMapper shopMapper;
}
