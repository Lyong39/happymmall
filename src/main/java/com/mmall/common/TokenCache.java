package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lwei on 2018/9/4.
 */
public class TokenCache {

    //声明日志
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);
    //声明静态内存块
    // initialCapacity:设置缓存的初始化容量
    // maximumSize:缓存的最大容量，超过这个容量的时候会使用LRU算法(最小使用算法)来移除缓存项
    //expireAfterAccess:设置有效期，
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    //设置key的方法
    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }

    //获取key的value方法
    public static String getKey(String key) {
        try {
            String value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("这是logger日志打印：localCache get error", e);
        }
        return null;
    }
}
