package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by Lwei on 2018/9/2.
 */
public class Const {
    //当前登录用户
    public static final String CURRENT_USER = "currentUser";
    //邮箱
    public static final String EMAIL = "email";
    //名称
    public static final String USERNAME = "username";
    //通过产品价格排序
    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    //管理等级
    public interface Role {
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;  //管理员
    }
    //产品状态的枚举，1 为在线
    public enum ProductStatusEnum {
        ON_SALE(1, "在线");
        private String value;
        private int code;

        ProductStatusEnum(int code, String value) {
            this.value = value;
            this.code = code;

        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }
}
