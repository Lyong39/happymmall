package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;


public interface ICartService {
    //添加商品到购物车
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
    //更新购物车中的商品数量
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    //删除购物车中的商品
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);
    //查看购物车中的商品
    ServerResponse<CartVo> list(Integer userId);
    //全选、全反选、单选、单反选购物车中的商品
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer checked,Integer productId);
    //查询购物车中商品的数量
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
