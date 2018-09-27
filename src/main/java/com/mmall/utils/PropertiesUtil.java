package com.mmall.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by Lwei
 */
public class PropertiesUtil {

    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;

    static {
        String fileName = "mmall.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }
    //从指定的文件中通过kye获取对应的value
    public static String getProperty(String key){
        String value = props.getProperty(key.trim()); //key.trim(去掉key两边的空格)
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    /**
     * 从指定的文件中通过kye获取对应的value
     * @param key
     * @param defaultValue  如果文件中key对应的value为空，就用这个默认的value
     * @return
     */
    public static String getProperty(String key,String defaultValue){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }



}
