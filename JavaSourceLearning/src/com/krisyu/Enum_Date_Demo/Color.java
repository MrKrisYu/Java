package com.krisyu.Enum_Date_Demo;

/**
 * @Author: Kris
 * @Date: 2021/1/4 - 01 - 04 - 16:42
 * @Description: com.krisyu.collectionDemo
 * @version: 1.0
 */
public enum Color implements Info{
    RED{
        public String getColor(){
            return "Hongse";
        }
    },
    BLUE{
        public String getColor(){
            return "lanse";
        }
    },
    YELLOW{
        public String getColor(){
            return "huangse";
        }
    };
}
