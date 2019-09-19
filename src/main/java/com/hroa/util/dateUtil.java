package com.hroa.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类
 */
public class dateUtil {

    //获取当前时间（格式：yyyy-MM-dd）
    public static Date currentDate(){
        Long date = new Date().getTime();
        Date current = new java.sql.Date(date);
        return current;
    }

    //string类型向date类型转换
    public static Date stringToDate(String dateString){
       try{
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           Date date = sdf.parse(dateString);
           return date;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
    }

    //date类型向String类型转换
    public static String dateToString(Date date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String stringDate = sdf.format(date);
            return stringDate;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
