package com.hroa.test;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mr.Hong on 2017/6/3.
 */
public class SerialTest {
    @Test
    public static void main(String[] args){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        //随机数
        int randomNumber = (int)(Math.random()*10000);
        String serialNumber = String.format("%04d",randomNumber);
        String office = "YP"+df.format(date)+serialNumber;
        System.out.print(office);
    }
}
