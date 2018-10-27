package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;


public interface IShippingService {
    //添加收获地址
    ServerResponse add(Integer userId, Shipping shipping);
    //删除收获地址
    ServerResponse<String> del(Integer userId, Integer shippingId);
    //更新收获地址
    ServerResponse update(Integer userId, Shipping shipping);
    //查询收获地址
    ServerResponse select(Integer userId, Integer shippingId);
    //查询收获地址分页
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}
