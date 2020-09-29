package com.yummy.entity;

import java.util.List;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-09-13 18:43
 */
public class Page<T> {
    //默认pageSize
    public static Integer DEFAULT_PAGE_SIZE = 4;
    //分页总数
    private Integer pageCount;
    //记录条数
    private Integer itemCount;
    //每页显示数据条目数
    private Integer pageSize;
    //当前页面号
    private Integer pageNow;
    //分页条请求地址
    private String url;
    //分页内容
    private List<T> items;

    public Page() {
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public static Integer getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
        //设置记录条目数的同时也将分页数设置
        int pageCount = this.itemCount / this.pageSize;
        if (this.itemCount % this.pageSize > 0) {
            pageCount++;
        }
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        //设置分页大小的同时 若总记录数已设置 则同时设置分页数目
        if (this.itemCount != null) {
            int pageCount = this.itemCount / this.pageSize;
            if (this.itemCount % this.pageSize > 0) {
                pageCount++;
            }
            this.pageCount = pageCount;
        }
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        //判断当前页码是否超出范围
        if (pageNow <= 1) {
            this.pageNow = 1;
        } else {
            this.pageNow = Math.min(pageNow, this.pageCount);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageCount=" + pageCount +
                ", itemCount=" + itemCount +
                ", pageSize=" + pageSize +
                ", pageNow=" + pageNow +
                ", url='" + url + '\'' +
                ", items=" + items +
                '}';
    }
}
