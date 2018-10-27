package com.mmall.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;


public class DateTimeUtil {

    //joda-time

    /**
     * str类型时间-->Date类型时间
     * @param dateTimeStr:时间字符串
     * @param formatStr:时间类型格式
     * @return
     */
    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * Date类型时间-->str类型时间
     * @param date:Date类型时间
     * @param formatStr:时间类型格式
     * @return
     */
    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
        //运行结果为:2018-09-25 21:34:41
        System.out.println(DateTimeUtil.strToDate("2010-01-01 11:11:11","yyyy-MM-dd HH:mm:ss"));
        //运行结果为:Fri Jan 01 11:11:11 CST 2010
    }


    //声明一个转成Date类型字符串的格式，下面两个方法重载，其实跟上面的两个方法一样的
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }





}
