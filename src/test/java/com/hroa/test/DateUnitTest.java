package com.hroa.test;

import org.junit.Test;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mr.Hong on 2017/6/4.
 */
public class DateUnitTest {
    @Test
    public void dateUnit(){
        Date sqlDate = new java.sql.Date(new Date().getTime());
        System.out.print(sqlDate);
    }
}
