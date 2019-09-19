package com.hroa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编号类
 */
public class SerialUtil {

    //产生随机数
    public static String serial(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        //随机数（0001-9999）
        int randomNumber = (int)(Math.random()*10000);
        String serialNumber = String.format("%04d",randomNumber);
        String serial = df.format(date)+serialNumber;
        return serial;
    }
    

    //获得四位随机数 
    public static String serial4(){
        int randomNumber = (int)(Math.random()*10000);
        String serialNumber = String.format("%04d",randomNumber);
        return serialNumber;
    }
    

    //办公用品编号
    public static String officeSerial(){
        String office = "YP"+ SerialUtil.serial();
        return office;
    }

    //收入管理编号
    public static String incomeSerial(){
        String income = "SR"+ SerialUtil.serial();
        return income;
    }

    //工资管理
    public static String salarySerial(){
        String salary = "GZ"+ SerialUtil.serial();
        return salary;
    }

    //工资详情
    public static String salaryDetailSerial(){
        String salaryDetail = "SD" + SerialUtil.serial();
        return salaryDetail;
    }
}
