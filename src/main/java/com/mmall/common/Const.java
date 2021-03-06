package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;


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

    //产品是否在购物车中勾选(结账只会结账勾选的)
    public interface Cart {
        //购物车选中状态
        int CHECKED = 1;
        //购物车中未选中状态
        int UN_CHECKED = 0;
        //库存与购物车商品数量的限制(存在用户添加商品超出库存的现象)
        //限制失败
        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        //限制成功
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
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

    //支付状态枚举
    public enum OrderStatusEnum {

        CANCELED(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭");

        OrderStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public static OrderStatusEnum codeOf(int code){
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode()==code){
                    return orderStatusEnum;
                }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }

    public interface AlipayCallback {
        //交易创建，等待买家付款
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
        //交易支付成功
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    public enum PayPlatformEnum {
        ALIPAY(1, "支付宝");

        PayPlatformEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PaymentTypeEnum {
        ONLINE_PAY(1, "在线支付");

        PaymentTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }

        public static PaymentTypeEnum codeOf(int code){
            for (PaymentTypeEnum paymentTypeEnum : values()) {
               if (paymentTypeEnum.getCode()==code){
                   return paymentTypeEnum;
               }
            }
            throw new RuntimeException("没有找到对应的枚举");
        }
    }
}
