package com.mmall.service;


import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;


public interface IUserService {
    //用户登录
    ServerResponse<User> login(String username, String password);
    //用户注册
    ServerResponse<String> register(User user);
    //校验
    ServerResponse<String> checkValid(String str, String type);
    //获取找回密码的问题
    ServerResponse<String> selectQuestion(String username);
    //校验找回密码问题答案
    ServerResponse<String> checkAnswer(String username, String quertion, String answer);
    //忘记密码的重置密码
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);
    //登录状态的重置密码
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);
    //更新用户信息
    ServerResponse<User> updateInformation(User user);
    //获取用户信息
    ServerResponse<User> getInformation(Integer userId);
    //校验管理员
    ServerResponse checkAdminRole(User user);
}
