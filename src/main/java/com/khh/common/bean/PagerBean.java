package com.khh.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/1/6.
 */
public class PagerBean<T> implements Serializable {

    // 当前页码
    private int pageNo = 1;

    // 每页数量
    private Integer pageSize = 5;

    // 记录总数
    private Integer totalCount;

    // 页码数量
    private Integer pageCount;

    //从哪里开始查询
    private Integer start;

    //关键字
    private Map<String,String> keyMap = new HashMap<>();

    /**
     * 查询出来的数据
     */
    private List<T> data = new ArrayList<T>();

    public PagerBean() {

    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Map<String, String> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<String, String> keyMap) {
        this.keyMap = keyMap;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
