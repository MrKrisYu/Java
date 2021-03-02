package com.krisyu.Enum_Date_Demo;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Kris
 * @Date: 2021/1/3 - 01 - 03 - 16:35
 * @Description: learning of Collections
 * @version: 1.0
 */
public class DateDemo1 {
    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        calendar.set(Calendar.MONTH, 11);
//        System.out.println(f.format(calendar.getTime()));
//        calendar.roll(Calendar.DATE, 30);
//        System.out.println(f.format(calendar.getTime()));
//        calendar.add(Calendar.DATE, 30);
//        System.out.println(f.format(calendar.getTime()));
//        System.out.println("YEAR = " + calendar.get(Calendar.YEAR));
//        System.out.println("MONTH = " + calendar.get(Calendar.MONTH));
//        System.out.println("DATE = " + calendar.get(Calendar.DATE));
//        System.out.println("DAY_OF_MONTH = " + calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println("WEEK_OF_MONTH = " + calendar.get(Calendar.WEEK_OF_MONTH));
//        System.out.println("WEEK_OF_YEAR = " + calendar.get(Calendar.WEEK_OF_YEAR));
//        System.out.println("DAY_OF_WEEK = " + calendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println("DAY_OF_WEEK_IN_MONTH = " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//        System.out.println("AM_PM = " + calendar.get(Calendar.AM_PM));
//        System.out.println("Hour = " + calendar.get(Calendar.HOUR));
//        System.out.println("HOUR_OF_DAY = " + calendar.get(Calendar.HOUR_OF_DAY));
//        System.out.println("MINUTE = " + calendar.get(Calendar.MINUTE));
//        System.out.println("SECOND = " + calendar.get(Calendar.SECOND));
//        System.out.println("MILLISECOND = " + calendar.get(Calendar.MILLISECOND));
//        System.out.println("ZONE_OFFSET = " + calendar.get(Calendar.ZONE_OFFSET));
//        System.out.println("DST_OFFSET = " + calendar.get(Calendar.DST_OFFSET));
        System.out.println(calendar.getDisplayName(Calendar.DATE, Calendar.LONG, Locale.CANADA));


    }
}
