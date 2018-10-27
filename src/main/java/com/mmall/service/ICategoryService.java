package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;


public interface ICategoryService {
    //添加商品分类
    ServerResponse addCategory(String categotyName, Integer parentId);
    //更新分类名称
    ServerResponse updateCategoryName(String categoryName, Integer categoryId);
    //获取商品分类的子分类，不递归
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    //获取商品分类ID及递归子分类ID的获取
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
