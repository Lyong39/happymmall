package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * Created by Lwei on 2018/9/19.
 */
public interface IProductService {
    //增加或者更新商品
    ServerResponse saveOrUpdateProduct(Product product);
    //后台商品上下架
    ServerResponse setSaleStatus(Integer productId,Integer status);
    //后台商品详情
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
    //后台商品列表
    ServerResponse getProductList(int pageNum, int pageSize);
    //后台商品搜索
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);
    //前台产品搜索
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);
    //前台动态排序列表
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);
}
