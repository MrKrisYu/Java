package com.krisyu.Enum_Date_Demo;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 16:27
 * @Description: com.krisyu.collectionDemo
 * @version: 1.0
 */
public enum Day {

    MONDAY{
        public String getDay(){
            return "星期一";
        }
    },
    TUESDAY{
        public String getDay(){
            return "星期二";
        }
    },
    WEDNESDAY{
        public String getDay(){
            return "星期三";
        }
    };
    public abstract String getDay();
}
